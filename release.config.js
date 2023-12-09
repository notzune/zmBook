module.exports = {
  branches: ['main'], // replace with your default branch if it's not "main"
  repositoryUrl: 'https://github.com/notzune/zmBook.git', // Explicitly set the repo URL
  plugins: [
    '@semantic-release/commit-analyzer', // for analyzing commit messages
    '@semantic-release/release-notes-generator', // for generating release notes
    [
      '@semantic-release/changelog', // for updating the CHANGELOG.md file
      {
        "changelogFile": "CHANGELOG.md",
      }
    ],
    [
      '@semantic-release/git', // for committing and pushing changes
      {
        assets: ['CHANGELOG.md', 'package.json'],
        message: 'chore(release): ${nextRelease.version} [skip ci]\n\n${nextRelease.notes}'
      }
    ],
    '@semantic-release/github' // for creating a GitHub release
  ]
};