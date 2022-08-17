FROM openjdk:18-alpine
ARG PACKAGE_NAME=first_consumer
WORKDIR /app

COPY .mvn/ .mvn
COPY mvnw pom.xml ./
RUN ./mvnw dependency:resolve
COPY src ./src
ENV PACKAGE_NAME ${PACKAGE_NAME}

CMD ["./mvnw", "spring-boot:run"]