FROM openjdk:17-jdk-alpine
RUN mkdir /app
WORKDIR /app
ADD target/*.jar ./app.jar
ENTRYPOINT ["java","-jar","app.jar"]