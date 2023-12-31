# TechX Test
# Pre-requisites
- Git
- Postman
- PC/Mac/Laptop
- Java
- Maven
- IntelliJ
# Deployment

Link: https://techx-e77470333148.herokuapp.com/

# TechX

How to start the TechX application
---
### Option 1
1. Run `mvn clean install` to build your application
1. Start application with `java -jar target/techx-1.0-SNAPSHOT.jar server config.yml`
1. To check that your application is running enter url `http://localhost:9090`
### Option 2 
1. Clone and open project in IntelliJ
2. Open Run/Debug Configurations -> Edit SDK , program argument , class similar to the image
![image](https://github.com/malliaw2808/TechX/assets/13903635/64b67a81-c420-4769-b481-6f0eb4fc50ce)
3. SHIFT + F10 to run the program

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

# Author
Nguyen Tuan Anh - email: tuananh131001@gmail.com

# Requirement
```
# Assessment Test
Technology:
- Dropwizard API Framework
Write an API for a background job poller. The job can be simple as a sleep for 10 seconds.
API Req:
- /job/submit : Submit the job for execution
- /job/{id}/status: Get Job status
The storage of the job status and architecture is up to the developer to choose from.
```
