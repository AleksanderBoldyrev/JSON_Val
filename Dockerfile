FROM alpine:3.2
RUN apk --update add openjdk7-jre
# Set the working directory to /app
WORKDIR /app

# Copy the current directory contents into the container at /app
ADD . /app

# Make port 80 available to the world outside this container
EXPOSE 80

# Define environment variable
ENV NAME World

# Run app.py when the container launches
CMD ["/usr/bin/java", " -jar ValidatingService.jar -classpath com.alex.Main"]
