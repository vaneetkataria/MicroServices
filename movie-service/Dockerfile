FROM java:8u111-jre-alpine
MAINTAINER vaneetkataria54@gmail.com
COPY target/movie-service-0.0.1-SNAPSHOT.jar /App.jar
EXPOSE 8100
VOLUME /tmp
ENTRYPOINT ["java", "-jar" ,  "/App.jar"]

