<a href="https://github.com/jmg2014/twitter-app/blob/master/LICENSE"><img src="https://img.shields.io/badge/License-Apache%202.0-blue.svg" alt="License"></a>

#Airlane application

This is an ongoing project to manage an airlane company using Spring Cloud Netflix


##The project has the following modules:

### Airlane-config-service

Spring Cloud Configuration Server to manage external properties across all environments. 

### Airlane-discovery-service

Netflix Eureka allows microservices to register themselves at runtime. 

### Airlane-edge-service

This is the API gateway using Zuul. 


### Airlane-webapp

The web application provides the main interface of the online airlane backend. Users are able to manage the aircrew and the destinations of the flights.