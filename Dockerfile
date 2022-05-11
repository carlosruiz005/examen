# Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
# Click nbfs://nbhost/SystemFileSystem/Templates/Other/Dockerfile to edit this template

#FROM alpine:latest

#CMD ["/bin/sh"]

#FROM openjdk:8-jdk-alpine
FROM openjdk:11
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} examen-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/examen-0.0.1-SNAPSHOT.jar"]