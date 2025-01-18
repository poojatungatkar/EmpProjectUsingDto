FROM openjdk:8
EXPOSE 8082
ADD target/employee-devops-integration.jar employee-devops-integration.jar
ENTRYPOINT ["java", "-jar","/employee-devops-integration.jar"]