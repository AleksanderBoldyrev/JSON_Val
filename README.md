# JSON_Val

The JSON Validation Service (JVS) is a validator that allows every users to check JSON objects for compliance with the JSON grammar.

In this project the JsonSimple library was used: https://github.com/fangyidong/json-simple

https://github.com/AleksanderBoldyrev/JSON_Val

# To deploy:
docker run -d -p 80:80 a13xx/json

(for gradle build: ./gradlew docker && docker run -d -p 80:80 validation-service)

curl -s --data-binary @filename.json http://localhost:80
