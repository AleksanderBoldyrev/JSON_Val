# JSON_Val

The JSON Validation Service (JVS) is a validator that allows every users to check JSON objects for compliance with the JSON grammar.

https://github.com/AleksanderBoldyrev/JSON_Val

# To deploy:
docker run -d -p 80:80 a13xx/json

curl -s --data-binary @filename.json http://localhost:80
