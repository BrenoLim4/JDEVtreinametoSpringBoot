FROM openjdk:8-jdk-alpine
COPY .target/spring_rest_Api_sample-0.0.1-SNAPSHOT.jar /usr/app/
WORKDIR /usr/app/
EXPOSE 8084
ENTRYPOINT ["java", "-jar", "spring_rest_Api_sample-0.0.1-SNAPSHOT.jar" ]
