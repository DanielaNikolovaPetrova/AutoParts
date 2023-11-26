----------Auto Parts-------------
--Used --
Java 17
Spring Boot 3.2.0
Maven
MySQL

--Dependencies--
Spring Data JPA
MySql Driver
SpringWeb
Validation
Lombok
Spring Security Core
JJWT::Api
JJWT::Impl
JSONWebToken
Spring Security Web

!!!In application.yml you need to set correct database parameters

--For testing
First you need to insert some data. You can add objects one by one or in a groups.
The first way example: 
1. Register admin POST http://localhost:8080/api/v1/user/register with body
{
    "username": "adminUsername",
    "password": "adminPassword",
    "userRole": "ADMIN"
}
2. Log in as an admin POST http://localhost:8080/api/v1/user/login, body:
{
    "username": "adminUsername",
    "password": "adminPassword"
}
3. Add Make/manifacturer - POST http://localhost:8080/api/v1/make/add-make, body:
{
	"name": "makeName"
}
4. Add Part Category - POST http://localhost:8080/api/v1/part-category/add-part-category, body:
{
	"name": "partCategoryName",
	"description": "partCategoryDescription"
}
5. Add Model - POST http://localhost:8080/api/v1/model/add-model, body:
{
    "name": "modelName",
    "make":{
        "id": makeid
    }
}
6. Add Part POST localhost:8080/api/v1/part/add-part, body:
{
    "name": "partName",
    "price": partPrice,
    "partCategory":{
        "id": partcategoryId
    },
    "model":[
        {"id": modelId},
        {"id": modelId}
    ]
}

The second way is inserting example files:
!!! This option is for testing purposes. The data in files is for example. There are no validation and authentication for these files!
1.Adding makes - POST http://localhost:8080/api/v1/make/auth/insert-data?csvFilePath=make.csv
Params: Key csvFilePath, Value make.csv

--to do Add Model, Add PartCategory, Add Part from csv
