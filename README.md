![Logo](https://github.com/user-attachments/assets/8cafd5c4-e4e9-4bba-96d7-e3e4a7e3cb82)
# Spring Security Demo Project.


A Spring Security project for self learning. I used Security to authenticate endpoints using the role system, allowing only specific users to make certain requests. I used a disease registration system with some fields such as CID, Name, Symptoms, etc.

# Stack used:
* [*SpringSecurity*](https://docs.spring.io/spring-security/reference/index.html)
* [*Auth0 JWT Lib*](https://github.com/auth0/java-jwt)
* [*BCrypt Encoder*](https://docs.spring.io/spring-security/site/docs/current/api/org/springframework/security/crypto/bcrypt/BCrypt.html)
* [*Java*](https://docs.oracle.com/en/java/javase/17/docs/api/index.html)
* [*SpringBoot*](https://docs.spring.io/spring-boot/index.html)
* [*Maven*](https://maven.apache.org/guides/index.html)
* [*PostgreSQL*](https://www.postgresql.org/docs/)

# Doc:

## Login:
To use the API you will first have to login, there ar two roles for users:
* ADMIN: Has all permissions, can register a new user and register a disease. (user.user@Zex.com).
* USER: Can only do queries, such as: find all, find by id and find by symptoms. (admin.admin@Zex.com).

Who can make this request ?

| ALL |
|:------|

#### Path:
```http
POST /auth/login/
```
#### Body:
```json
{
  "login": "user.user@Zex.com",
  "password": "user123"
}
```
#### Response:
A JWT (JSON Web Token) will be returned in the response body, you must use it in future requests. To log in as ADMIN use: ```admin.admin@Zex.com```


## Sign in:
Who can make this request ?

| ADMIN |
|:------|

#### Path:
```http
POST /auth/signup/
```
#### Body:
```json
{
  "login": "user.user@Zex.com",
  "password": "user123",
  "role": "USER"
}
```
Create a new user in the database.


## Return all diseases:
Who can make this request ?

| ADMIN | USER |
|:------|:-----|

#### Path:
```http
GET /disease/
```

Returns all diseases registered in database.


## Register new disease:
Who can make this request ?

| ADMIN |
|:------|

#### Path:
```http
POST /disease/
```
#### Body:
```
{
  "cid": "H81.0",
  "name": "Labyrinthitis",
  "symptoms": ["Dizziness", "Vertigo", "Nausea", "Loss of balance"],
  "treatments": ["Medication for nausea and dizziness", "Vestibular physiotherapy", "Antibiotics (if there is an infection)", "Rest"],
  "risk": 3
}

```

Register a new disease in database.


## Find by id:
Who can make this request ?

| ADMIN | USER |
|:------|:-----|

#### Path:
```http
GET /disease/{id}
```
| Parâmetro   | Tipo       | Descrição                           |
| :---------- | :--------- | :---------------------------------- |
| `id` | `string` | Disease ID

Returns the disease with the chosen ID.



## Find by symptoms:
Who can make this request ?

| ADMIN | USER |
|:------|:-----|

#### Path:
```http
GET /disease/
```

#### Body:
```
{
 "symptoms": "vertigo"
}
```

Returns all disease with these symptoms.



