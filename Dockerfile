FROM openjdk:11
RUN mkdir /app
WORKDIR /app
ADD target/*.jar ./app.jar
ENTRYPOINT ["java","-jar","app.jar"]