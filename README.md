# LaskutusDemo
This application used to validate the given Finnish SSN.

## Prerequisite
Following tools required,
 * java 17
 * Maven 3.8

## Unit test
 ``` 
 mvn clean install
 mvn clean test
 ```

 ## API test

```
mvn spring-boot:run
```


 ### Using postman

 ``` 
 http://localhost:8080/validate_ssn
 ```
 Request :
```
{
    "ssn":"131052-308T",
    "countryCode":"FI"
}
```
Response:

```
{
    "ssn_valid": true
}
```

* For invalid SSN it returns `false`

* For invalid input it returns `Invalid Input`



