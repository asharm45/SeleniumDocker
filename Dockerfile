FROM openjdk:8u191-jre-alpine3.8

RUN apk add curl jq

# Workspace - it can be any location
WORKDIR /Users/amitsharma/Documents/Docker

# Add .jar files under target from host into this image
ADD target/selenium-docker.jar          selenium-docker.jar
ADD target/selenium-docker-tests.jar    selenium-docker-tests.jar
ADD target/libs                         libs

# Add any other .xls or .cvs or .properties files like that

# Now add suite file/files
ADD testng.xml                          testng.xml

#ADD healthcheck.sh
ADD healthcheck.sh                      healthcheck.sh

# We are going to parametrized browserName, hostName and module (could be different .xml file in a project)

ENTRYPOINT sh healthcheck.sh

#Expected variables - since we are using healthcheck, the entrypoint will change
#BROWSER
#HUB_HOST
#MODULE
#ENTRYPOINT java -cp "selenium-docker.jar:selenium-docker-tests.jar:libs/*" -DBROWSER=$BROWSER -DHUB_HOST=$HUB_HOST org.testng.TestNG $MODULE