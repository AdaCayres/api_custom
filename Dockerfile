FROM openjdk:8-jdk-alpine
WORKDIR /src/minhaAPI
COPY . .
RUN javac ApiCustomApplication.java
CMD["java","ApiCustomApplication"]
