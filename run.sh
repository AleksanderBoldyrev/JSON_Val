mkdir jar
wget -P ./jar/ http://central.maven.org/maven2/com/googlecode/json-simple/json-simple/1.1/json-simple-1.1.jar
mkdir bin
javac -cp ".:./jar/json-simple-1.1.jar" -d ./bin ./src/main/java/com/alex/*.java
java -classpath ./bin:./jar/json-simple-1.1.jar com.alex.Main

