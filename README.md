# template-java

Java API template using SpringBoot


### Local

To compile: `./mvnw clean install`  
To run junit tests: `./mvnw test`  
To run: `./mvnw spring-boot:run`

### Swagger UI
http://localhost:8080/swagger-ui/index.html

### H2 database console
Access the H2 database web console at http://localhost:8080/h2-console  
See application.properties for login credentials and db url



## ToDo
- Make sure to sync swagger file outputs (naming, responses, ect)
- Finish project structure
- Add analyzers/linting
- Finish auto-fails for tests
- More Validation

## ToDo for Week 3
- parent pom
- data access layer
	- repositories
	- mocking/unit-testing
	- HA in-memory database
