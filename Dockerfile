FROM openjdk:11.0.14.1-jdk-slim-bullseye
ADD target/WeatherApiDemo-0.0.1-SNAPSHOT.jar .
COPY ./ /
EXPOSE $PORT
CMD java -jar WeatherApiDemo-0.0.1-SNAPSHOT.jar
