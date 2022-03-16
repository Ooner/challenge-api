## Requirements

For building and running the application you need:

- [JDK 11+](https://www.oracle.com/java/technologies/downloads/#java11)
- [Maven 3+](https://maven.apache.org)

## Running the application locally
There are several ways to run a Spring Boot application on your local machine.
1) One way is to execute the main method in the com.cognizant.challenge.ChallengeApplication class from your IDE.

2) Alternatively you can use the Spring Boot Maven plugin like so:
```shell
mvn spring-boot:run
```

3) Open terminal goto project directory then run
```shell
mvn clean install
```
goto /target directory and run
```shell
java -jar challenge-0.0.1-SNAPSHOT.jar
```

