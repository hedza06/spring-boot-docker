FROM openjdk:8u131-jre-alpine
COPY ./target/docker-*.jar app.jar
CMD ["/usr/bin/java", "-jar", "app.jar"]