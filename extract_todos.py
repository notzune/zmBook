import os
import re


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
    Main function to scan for TODOs and write them to a file.
    """
    # Define the directory containing Java files
    java_files_directory = '/Users/zeyad/Documents/GitHub/zmbook'

    # Initialize a set to keep track of TODOs that have already been seen
    seen_todos = set()

    # Open the TODO.md file for writing
    with open('TODO.md', 'w') as todo_file:
        # Walk through the directory
        for root, dirs, files in os.walk(java_files_directory):
            for file_name in files:
                if file_name.endswith('.java'):
                    java_file_path = os.path.join(root, file_name)

                    # Extract TODOs from the Java file
                    todos = extract_todos_from_file(java_file_path, seen_todos)

                    # Write found TODOs to the TODO.md file
                    for todo in todos:
                        print(f"Found TODO: {todo}")
                        todo_file.write(todo + '\n')


if __name__ == '__main__':
    main()
