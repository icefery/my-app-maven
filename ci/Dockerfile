FROM --platform=${TARGETPLATFORM} eclipse-temurin:17
ENV WORKDIR=/my-app
WORKDIR ${WORKDIR}
COPY target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
