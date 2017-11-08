# CollegeHero
Software for managing college student, professor, course, and tuition information. Class project for CS157A at San Jose State University, taught by Dr. Kim in Fall 2017.

Written in Java with a MySQL server linked with JDBC.

## Requirements
- Java 8+
- MySQL server

## Setup
1. Clone the repository
2. Run the SQL script: `mysql -u <user> -p < data/CollegeHero.sql`
3. Add JDBC to your CLASSPATH
4. Set your mysql DB username and password in config.properties (Warning: do not commit changes to config.properties! These are per user and if you want something else, add a new config.properties of your own in cfg. Ex. cfg/derek-config.properties)

## Contributing
After cloning the repository and setting up the application, find a [project](https://github.com/dereklopes/CollegeHero/projects) to work on. 

When you start working on a project, create a new branch (`git checkout -b <branch-name>`) and do all your work for that project on there. 

When you are finished, open a [pull request](https://github.com/dereklopes/CollegeHero/pulls) and post it in our slack channel so it can be reviewed.
