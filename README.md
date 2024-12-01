# Currency exchange REST API

## Overview

REST API for describing currencies and exchange rates.
Allows you to view and edit lists of currencies and exchange rates, and calculate conversion of arbitrary amounts from one currency to another.

## Technologies

- Java
- Maven
- Spring Boot
- PostgreSQL

## Endpoints

### GET ```/currencies```
Getting a list of currencies. Example answer:
```json
[
    {
        "id": 0,
        "name": "United States dollar",
        "code": "USD",
        "sign": "$"
    },   
    {
        "id": 0,
        "name": "Euro",
        "code": "EUR",
        "sign": "€"
    }
]
```
HTTP code response:
- OK - 200

### GET ``/currency/EUR``
Receipt of a specific currency. Example answer:
```json
{
    "id": 0,
    "name": "Euro",
    "code": "EUR",
    "sign": "€"
}
```

HTTP code response:
- OK - 200
- Currency not found - 404

### POST ``/currencies``
Adding a new currency to the base.
The sample response is a JSON representation of the inserted record, including its ID:
```json
{
    "id": 0,
    "name": "Euro",
    "code": "EUR",
    "sign": "€"
}
```
HTTP code response:
- SUCCESS - 201
- Currency with this code already exists - 409

The project was developed according to the [technical specifications](https://zhukovsd.github.io/java-backend-learning-course/projects/currency-exchange/), where you can find out all the remaining endpoints.
