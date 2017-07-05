## Development workflow

This practice is referred from https://medium.com/@readsethu/jooq-flyway-spring-boot-and-gradle-44a8d3f289

* write migration script and place it under src/main/resources/flyway/flyway/migrations
* run `mvn clean install`
    * run flyway to apply the migration script
    * run JOOQ to generate daos and db mapping object
* Check in code including migration sql file
    * Do not check in JOOQ generated file (should be handled by CI)
* CI will then run gradle clean build as well. 
    * But against a separate CI DB instance. 
    * The same locally steps will happen in the CI server. 
    * CI server will then package app with the generated JOOQ code and DB sql files.
* Deploy app onto production server.
* When app starts up, flyway will first execute your DB scripts before your spring boot app is available for incoming requests to be served.

## Packaging

App will be packaged with a jar file and its dependencies inside a lib folder
```
target
|-- ....
|-- my-project.jar
|-- lib
    |-- dependency1.jar
    |-- dependency2.jar
```

## Scripts

`db_setup.sh` 
* init data container
* set up db container and database

Build & run jar file
* mvn -P {profile} clean package
* java -jar -Dspring.profiles.active={profile} rest-tutorial-{version}.jar

## Profiles

There are 2 different type of profile
* Build profiles: maven profile to build application
    * dev: default profile used for dev environment
    * container: profile used for docker image
* Run profiles: spring profile to run application
    * dev: default profile used for dev environment
    * container: profile used for docker image

## Technologies

### [JOOQ](https://www.jooq.org/)

Features
* type safe sql
* code generation
* query dsl

Note
* to disable jooq flag on log, add this system properties `-Dorg.jooq.no-logo=true` 

### [Flyway](https://flywaydb.org/)

* migration script: `mvn flyway:migrate`
* repair check sum error: `mvn flyway:repair`

### Docker container

* Data container
* DB container
* App container

###  [Swagger]()

Use swagger to document Rest API
* api document with ui: http://localhost:8080/swagger-ui.html
* api document: http://localhost:8080/v2/api-docs

### [Lombok](https://projectlombok.org/)

Lombok used to avoid boilerplate code of getter,setter,toString...
* install Lombok plugin for intellij
* add lombok jar to maven pom

## Reference

In order to build this app, I take idea from below tutorials
* https://dzone.com/articles/microservice-architecture-with-spring-cloud-and-do
* http://www.baeldung.com/dockerizing-spring-boot-application
* https://github.com/spotify/dockerfile-maven
* https://medium.com/@basilio.vera/docker-compose-from-development-to-production-88000124a57c