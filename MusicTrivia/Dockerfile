FROM gradle:8.7.0-jdk21
WORKDIR /opt/app
COPY ./build/libs/MusicTrivia-0.0.1-SNAPSHOT.jar ./

ENTRYPOINT ["sh", "-c", "java ${JAVA_OPTS} MusicTrivia-jar -0.0.1-SNAPSHOT.jar"]