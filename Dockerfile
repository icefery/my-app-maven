FROM --platform=${TARGETPLATFORM} openjdk:17
ARG JAR_FILE=target/*.jar
ENV WORKDIR=/app
COPY ${JAR_FILE} ${WORKDIR}/app.jar
WORKDIR ${WORKDIR}
ENTRYPOINT ["java", "-jar", "app.jar"]
