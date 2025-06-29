[//]: # (![challenge banner]&#40;image/amaliTechLab.webp&#41;)
<img src="image/AmalitTech.png" alt="drawing" style="height:350px; width: 1000px"/>
# Advanced Lab1: Task Management API

![Static Badge](https://img.shields.io/badge/Framework_used-0-green?style=flat)
![GitHub followers](https://img.shields.io/github/followers/karangwaajika)
![GitHub file size in bytes](https://img.shields.io/github/size/karangwaajika/codeOfAfrica-challenges/index.html)


This lab evolves around developing a web application using Spring boot frameworks.
To have a hands-on experience with modern Java web application development understand 
the foundations of building and deploying Spring-based applications.

## Video

* Final Project: <a href="https://screenrec.com/share/jq8WAzS1rX"> Available here!</a>

## Diagram
* Component diagram: <a href="https://drive.google.com/file/d/1_ltTqN6KSubbTDNp-c-W7sVSpbAdLDPH/view?usp=sharing">Available here</a>
  <img src="image/componentDiagram.png" alt="drawing" style="height:250px; width: 1000px"/>

## Usage
* Backend codes: Logic behind (MVC Architecture)
    - controller handle http request and response
    - dao is where collection methods or functionalities are implemented
    - model holds project classes
    - service has the business logic
    - config create a singleton object for the collection.
    - exception handle custom exceptions
* Interactions between components:
    - Client ↔ Controller: HTTP requests and responses
    - Controller → Service: Invokes business logic methods
    - Service → Repository: Queries or updates data
    - Repository → Database: Executes SQL queries
    - Client ↔ Postman: View and test API endpoints

## Expected Learning Outcomes

- Understand and explain the purpose of Spring and Spring Boot.
- Demonstrate the use of IoC and DI using Spring.
- Develop a RESTful API using Spring MVC.
- Package and run a Spring Boot app inside a Docker container.
- Apply software engineering practices like separation of concerns and layered architecture.
