FROM java:8u111-jre-alpine
MAINTAINER vaneetkataria54@gmail.com
COPY zipkin-server-2.11.4-exec.jar /App.jar
EXPOSE 9411
VOLUME /tmp
ENTRYPOINT RABBIT_URI=amqp://centralrabbitmq java -jar /App.jar


