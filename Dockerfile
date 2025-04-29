FROM amazoncorretto:21-alpine

# handle jar path parameter
ARG JAR_PATH
ENV JAR_PATH=${JAR_PATH:-target/demo-service*.jar}

# change directory
WORKDIR /app

# copy jar inside container
COPY ${JAR_PATH} /app/app.jar

# expose port
EXPOSE 8080

# change user
USER 1001

ENTRYPOINT ["java"]
CMD ["-jar", "/app/app.jar"]