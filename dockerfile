FROM openjdk:11
MAINTAINER baeldung.com
COPY target/spring-mongo-int.jar spring-mongo-int.jar
ENTRYPOINT ["java","-jar","spring-mongo-int.jar"]
