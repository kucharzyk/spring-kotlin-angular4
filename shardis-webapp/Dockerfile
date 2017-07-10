FROM anapsix/alpine-java:8
ADD build/libs/shardis-0.1.5-SNAPSHOT.jar app.jar
RUN bash -c 'touch /app.jar'
EXPOSE 8080:8080
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
