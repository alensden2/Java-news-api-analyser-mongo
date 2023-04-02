# DMW Assignment 2
This program access a news api and using key words captures data, This data is then stored in the local machine and transformed. The cleaned data is then stored in a remote NOSQL database
## Table of Contents

- [Installation](#installation)
  - This project uses maven.
  - Mongo dependency
  - mvn build
  - mvn compile

## How to Run?
1. replace the credentials in the keys.prop file 
"src/main/java/APIAssets/keys.prop". API_KEY - Is the news ap key; username - is the mongo username; password - is the mongo password 
2. The ArticlesFiles contains all the articles "src/main/java/ArticlesFiles". if no directory is present please create one manually. 
3. Before running the application, manually delete all the files (.txt) under "src/main/java/ArticlesFiles". These are the old generated files, kept for reference.s
## Author

Alen John B00930528


