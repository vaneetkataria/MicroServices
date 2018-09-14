# Movie service
## Url : localhost:8100

# Songs service
## Url : localhost:8200 , 8203 , 8205

# Spring cloud config server
## Url : localhost:8300
## Url to fetch properties : http://localhost:8300/master/movie-service-dev.yml/ , http://localhost:8300/movie-service/dev/master

# Netflix eureka naming server
## Url : localhost:8761

# Zipkin
## Url : localhost:9411

# rabbitmq
## Url : localhost:15672

# Inside docker everything works on the same ports . 

# Host entries required for running without docker . 
## 127.0.0.1 namingServer
## 127.0.0.1 configServer
## 127.0.0.1 centralrabbitmq
  
            


