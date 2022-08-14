> Package to create jar
>> mvn package

> Build docker image using dockerfile
>> docker build -f dockerfile -t spring-mongo-int .

> Run docker image on port 9090 (Configured in the application.properties) and check if it runs
>> docker run -p9090:9090 spring-mongo-int/latest

> Send curl to the /post endpoint
>> curl --location --request POST 'http://localhost:9090/post' \
--header 'Content-Type: application/json' \
--data-raw '{
"email":"TestEmail",
"password":"TestPassword"
}'


