apt-get update 
apt-get install curl

ERROR_CODE=1

while [ "$ERROR_CODE" != "0" ]
do
    sleep 1
    echo "Waiting Database"
    curl -f http://database:3306/ezbase
    ERROR_CODE=$?
done

java -jar /home/ezstudio-api-0.0.1-SNAPSHOT.jar
