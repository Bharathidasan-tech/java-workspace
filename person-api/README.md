## PERSON RESTful API

An example PERSON RESTful API built on Spring Boot.

## Features

- RESTful API.
- Models with proper relationships.
- Controllers/Models etc with proper separation.
- oauth Authentication, used inMemoryAuthentication.
- Hibernate used for ORM.
- AngularJS v1.3, Bootstrap v3.3.7 used for Front end.
- For testing, H2 database used.
- Proper Integration Test.


### API Access

METHOD | PATH                                               | DESCRIPTION 
-------|----------------------------------------------------|------------
POST   | /oauth/token                                       | get oauth token to access the API
GET    | /api/person/?access_token={token_value}            | get all person list
GET    | /api/person/{person_id}?access_token={token_value} | get person details by ID list
POST   | /api/person/?access_token={token_value}            | save person details 
PUT    | /api/person/?access_token={token_value}            | update person
DELETE | /api/person/{person_id}?access_token={token_value} | delete person
