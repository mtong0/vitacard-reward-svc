FROM openjdk:17-oracle
RUN mvn -f ./reward-svc package
ARG JAR_FILE=./reward-svc/target/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]