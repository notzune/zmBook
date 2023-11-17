import logging
import os
import re
from datetime import datetime
from github import Github

logging.basicConfig(level=logging.INFO)


def get_code_snippet(file_name, line_number, context=3):
    """
    Get a snippet of code around a specific line in a file.

    :param file_name: The name of the file.
    :param line_number: The line number.
    :param context: How many lines before and after the line_number to fetch.
    :return: A string containing the code snippet.
    """
    with open(file_name, 'r') as f:
        lines = f.readlines()
    start = max(line_number - context - 1, 0)
    end = min(line_number + context, len(lines))
    snippet = ''.join(lines[start:end])
    return snippet


def find_todos_in_lines(lines, file_name, seen_todos):
    """
    Find TODO comments in a list of lines.

    :param lines: List of lines to scan.
    :param file_name: Name of the file being scanned.
    :param seen_todos: Set of TODOs that have already been found.
    :return: List of TODOs found.
    """
    todos = []
    for line_number, line in enumerate(lines, start=1):
        if re.search(r'//\s*TODO:', line, re.IGNORECASE):
            todo_line = line.strip().lower()
            if todo_line not in seen_todos:
                todos.append(f"{file_name}:{line_number}: {line.strip()}")
                seen_todos.add(todo_line)
    return todos


def extract_todos_from_file(file_path, seen_todos):
    """
    Extract TODO comments from a file.

    :param file_path: Path to the file.
    :param seen_todos: Set of TODOs that have already been found.
    :return: List of TODOs found.
    """
    with open(file_path, 'r') as file:
        lines = file.readlines()
    file_name = os.path.splitext(os.path.basename(file_path))[0]
    return find_todos_in_lines(lines, file_name, seen_todos)


def main():
    """
    Main function to scan for TODOs and create GitHub issues for them.
    """
    # Load environment variables
    github_access_token = os.getenv('GITHUB_ACCESS_TOKEN')
    github_repository_name = os.getenv('GITHUB_REPOSITORY')

    # Initialize the GitHub client
    github_client = Github(github_access_token)
    github_repo = github_client.get_repo(github_repository_name)
    latest_commit_sha = github_repo.get_commits()[0].sha

    # Initialize a set to keep track of TODOs that have already been seen
    seen_todos = set()

    # Open the TODO.md file for writing
    with open('TODO.md', 'r') as todo_file:
        for line in todo_file:
            parts = line.strip().split(': ', 2)
            if len(parts) != 3:
                logging.warning(f'Skipping line due to unexpected format: {line.strip()}')
                continue

            file_name, line_number_str, todo_description = parts
            try:
                line_number = int(line_number_str)
            except ValueError:
                logging.warning(f'Skipping line due to invalid line number: {line.strip()}')
                continue

            title = todo_description
            snippet = get_code_snippet(file_name, line_number)
            current_time = datetime.now().strftime("%Y-%m-%d %H:%M:%S")
            body = f'''### TODO Description
{todo_description}

### File
[Link to File](https://github.com/{github_repository_name}/blob/main/{file_name}#L{line_number})

### Code Snippet
\`\`\`java
{snippet}
\`\`\`

### Created At
{current_time}

### Latest Commit SHA
{latest_commit_sha}
'''
            existing_issue = None
            for issue in github_repo.get_issues(state='open'):
                if issue.title == title:
                    existing_issue = issue
                    break

            if existing_issue is None:
                labels = ["TODO", "needs-review"]
                github_issue = github_repo.create_issue(title=title, body=body, labels=labels)
                logging.info(f'Created GitHub issue: {title}')
            else:
                logging.info(f'GitHub issue already exists: {title}')


if __name__ == '__main__':
    main()
