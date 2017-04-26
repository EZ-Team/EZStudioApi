FROM openjdk
COPY ./build/libs/ezstudio-api-0.0.1-SNAPSHOT.jar /home/ezstudio-api-0.0.1-SNAPSHOT.jar
COPY ./start.sh /home
CMD ["chmod", "+x", "/home/start.sh"]
ENTRYPOINT /home/start.sh
EXPOSE 8080

