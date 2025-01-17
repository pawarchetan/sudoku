# create base image with all dependencies
FROM openjdk:17 AS Build
COPY pom.xml mvnw ./
COPY .mvn .mvn
RUN ./mvnw dependency:resolve

COPY src src
RUN ./mvnw package

FROM openjdk:17
VOLUME /tmp
EXPOSE 8080
COPY --from=build target/*.jar app.jar
ENTRYPOINT [ "java", "-jar","app.jar" ]