# spring-boot-karate-demo

This demo project is a POC for Docker & Distroless docker integration

Also it implements Karate for validating REST Endpoints

To build the application:
-------------------------

<localInstallPath>/gradle build test docker

To run the image:
-----------------

docker run -d -p 8182:8182 docker-distroless-app:latest

Environment Variables required to run the test cases:
BASEURL=http://localhost:8182
FIRSTNAME=prabhu
LASTNAME=namachivayam
DEMO_PORT=8182

Docker images instance details for reference,
# spring-boot-karate-demo

This demo project is a POC for Docker & Distroless docker integration

Also it implements Karate for validating REST Endpoints

To build the application:
-------------------------

<localInstallPath>/gradle build test docker

To run the image:
-----------------

docker run -d -p 8182:8182 docker-distroless-app:latest

Environment Variables required to run the test cases:
BASEURL=http://localhost:8182
FIRSTNAME=prabhu
LASTNAME=namachivayam
DEMO_PORT=8182

Docker images instance details for reference,

**REPOSITORY**|**TAG**|**IMAGE ID**|**CREATED**|**SIZE**
:-----:|:-----:|:-----:|:-----:|:-----:
docker-distroless-app|latest|01931f4e8bfd|3 hours ago|142MB
<none>|<none>|810bfe709342|3 hours ago|112MB
docker-app|latest|62d291f36b6f|3 hours ago|132MB
  
