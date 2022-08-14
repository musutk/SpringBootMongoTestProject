> mvn package

>docker build -f dockerfile -t spring-mongo-int . 

>docker run -p9090:9090 spring-mongo-int/latest

>docker run -p9090:9090 spring-mongo-int/latest --spring.config.location=classpath:${configDirectory}"

