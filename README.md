# Acsel-e

# Serenity JUnit Starter project

This is a very minimal sample project using JUnit and Serenity BDD in Java. 
You can use this project as a quick starting point for your own projects.
## Google Version

	Version 87.0.4280.88 (Official Build) (64-bit)

## Maven version
	
	Version 3.6.2

## Java jdk Version
 	
	1.8.0

## Get the code

Git:

    git clone https://github.com/jzabalaserrano/Acsel-e
    cd Acsel-e


Or simply [download a zip](https://github.com/jzabalaserrano/Acsel-e) file.

## Use Maven to run 5 automated test cases

Open a command window and run:

    mvn clean verify


## Use Maven to run a specific case from this list
	
	@userSucessfulLogin

Example:
- Open a command window and run:

	mvn test -Dcucumber.options="--tags @userSucessfulLogin"
	
	

## Viewing the reports

Both of the commands provided above will produce a Serenity test report in the `target/site/serenity` directory. Go take a look!