FROM java:8-jdk-alpine

ADD target/FindThePlane-0.0.1-SNAPSHOT.jar docker-spring-boot.jar

EXPOSE 8080

ENTRYPOINT ["java","-jar","docker-spring-boot.jar"]
