FROM openjdk
COPY ./build/libs/ezstudio-api-0.0.1-SNAPSHOT.jar /home/ezstudio-api-0.0.1-SNAPSHOT.jar
CMD ["java","-jar","/home/ezstudio-api-0.0.1-SNAPSHOT.jar"]
EXPOSE 8080

