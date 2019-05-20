FROM gradle:jdk11 as builder

COPY . /home/gradle/project
USER root
WORKDIR /home/gradle/project/
RUN gradle clean build


FROM openjdk:11-slim as runtime
EXPOSE 8080
ENV APP_HOME /app

WORKDIR $APP_HOME
#Copy executable jar file from the builder image
COPY --from=builder /home/gradle/project/build/libs/*.jar app.jar

ENTRYPOINT [ "sh", "-c", "java -Djava.security.egd=file:/dev/./urandom -jar app.jar" ]
