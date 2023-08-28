# TechX Test
# Pre-requisites
- Git
- Postman
- PC/Mac/Laptop
- JAVA
- Maven
- IntelliJ
# Deployment

Link: https://techx-e77470333148.herokuapp.com/

# TechX

How to start the TechX application
---

1. Run `mvn clean install` to build your application
1. Start application with `java -jar target/techx-1.0-SNAPSHOT.jar server config.yml`
1. To check that your application is running enter url `http://localhost:9090`


# API

## CREATE job

POST `localhost:9090/job/submit` ||  `https://techx-e77470333148.herokuapp.com/job/submit`
![image](https://github.com/malliaw2808/TechX/assets/13903635/4ec660e8-ec3b-4426-91c9-4194e1e343f5)

## GET job by id 
GET `localhost:9090/job/:id/status` || `https://techx-e77470333148.herokuapp.com/job/:id/status`
![image](https://github.com/malliaw2808/TechX/assets/13903635/5e26b82b-f650-416f-bf4e-3092cc77d424)
![image](https://github.com/malliaw2808/TechX/assets/13903635/28d3c841-f6ca-42be-8404-daa9510eba16)


## GET all jobs
GET `localhost:9090/job` || `https://techx-e77470333148.herokuapp.com/job`
![image](https://github.com/malliaw2808/TechX/assets/13903635/67354f16-25a7-458e-a170-75a2a3ef29c4)

# Testing

PASSED ALL TESTING Representations and Resources
![image](https://github.com/malliaw2808/TechX/assets/67695658/053182be-668a-4c3e-b0ce-58c782a849f7)
