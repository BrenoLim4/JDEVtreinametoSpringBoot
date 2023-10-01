FROM openjdk:8-jdk-alpine
COPY .target/spring_rest_Api_sample-0.0.1-SNAPSHOT.jar /home/apps/
WORKDIR /home/apps/
EXPOSE 8084
ENTRYPOINT ["java", "-jar", "spring_rest_Api_sample-0.0.1-SNAPSHOT.jar" ]
