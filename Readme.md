
## W2M - Hiberus : Spring boot , Maven , Java 8 , Flyway, H2,Eception Handling, Spring Security , Spring JPA , Swagger ,Prometheus, Docker,Lombok ,Junit.

### Sr Developer José Francisco valdez 
 Linkedin https://www.linkedin.com/in/jose-francisco-valdez-282a1b1a/

## How it works:
## 1- Runs as Spring boot app.


### Clone the repository:
1) git clone https://github.com/pilon33/jfvtest-w2m.git


2) Update maven project  
3) Build project 
4) Runs As --> Spring Boot App 

### Tester in Swagger UI:

http://localhost:8080/swagger-ui.html


### POST request to `/super-heroes/create
* Example: curl -X POST "http://localhost:8080/super-heroes/create" -H  "accept: */*" -H  "Content-Type: application/json" -d "{\"id\":1,\"name\":\"clark ken\",\"namePower\":\"homnbre hierro\",\"superName\":\"superman\",\"profession\":\"periodista\",\"worldNamebBorn\":\"marte\",\"age\":20,\"canFly\":true}"


### GET request to `/super-heroes/{id}
* Example: curl -X GET "http://localhost:8080/super-heroes/1" -H  "accept: */*"


### PUT request to `/super-heroes​/update​/{id}
* Example: curl -X PUT "http://localhost:8080/super-heroes/update/1" -H  "accept: */*" -H  "Content-Type: application/json" -d "{\"id\":1,\"name\":\"jhon\",\"namePower\":\"boina verde\",\"superName\":\"Rambo\",\"profession\":\"militar\",\"worldNamebBorn\":\"tierra\",\"age\":23,\"canFly\":false}"


### GET request to `/super-heroes/name-like/{name}

* Example: curl -X GET "http://localhost:8080/super-heroes/name-like/man" -H  "accept: */*"

### DELETE request to `/super-heroes/delete/{id}

* Example: curl -X GET "http://localhost:8080/super-heroes/name-like/man" -H  "accept: */*"


## 2- Run Test from Image Docker Hub :

* docker pull jfvadez/jfvtest-w2m-docker-img

* docker run -p 8080:8080 jfvadez/jfvtest-w2m-docker-img


## 3- Credentials :


### Authentication --> /jfvtest-w2m/src/main/resources/application.properties

* username=user@user.com

* password=user



### H2 --> /h2-console 

* username=sa

* password=sa


### script bd --> /jfvtest-w2m/src/main/resources/db/migration

