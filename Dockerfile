FROM openjdk:11
VOLUME /tmp
EXPOSE 8888
ADD target/ms-sp-podologyapp-user-0.0.1-SNAPSHOT.jar podology-user.jar
ENTRYPOINT [ "java", "-jar", "/podology-user.jar" ]