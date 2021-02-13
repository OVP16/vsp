FROM openjdk:12
VOLUME /tmp
EXPOSE 8080
ADD ./target/prueba-bcp-0.0.1-SNAPSHOT.jar pruebita.jar
ENTRYPOINT ["java","-jar","/pruebita.jar"]