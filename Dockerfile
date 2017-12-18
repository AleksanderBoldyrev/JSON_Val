#FROM alpine:3.2
#RUN apk --update add openjdk7-jre
#RUN apk add --no-cache bash git openssh
# Set the working directory to /app
#WORKDIR /app

# Copy the current directory contents into the container at /app
#ADD . /app

# Make port 80 available to the world outside this container
#EXPOSE 80

# Define environment variable
#ENV NAME World

#ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/ValidatingService.jar"]


FROM maven:3.3-jdk-8-onbuild
CMD ["java","-jar","/target/ValidatingService.jar"]
EXPOSE 80
