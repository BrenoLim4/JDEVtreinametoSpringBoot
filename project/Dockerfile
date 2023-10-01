FROM openjdk:8-jre-slim
WORKDIR /home/apps
COPY target/spring_rest_Api_sample-0.0.1-SNAPSHOT.jar app/spring_rest_Api_sample-0.0.1-SNAPSHOT.jar
EXPOSE 8084
CMD [ "java", "-jar", "spring_rest_Api_sample-0.0.1-SNAPSHOT.jar" ]
