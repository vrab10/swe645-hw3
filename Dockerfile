FROM openjdk:17
COPY ./target/Feedback.jar .
ENTRYPOINT ["java", "-jar", "Feedback.jar"]
EXPOSE 8080