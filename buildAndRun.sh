#!/bin/sh
mvn clean package && docker build -t lt.verbus/LearningCDI .
docker rm -f LearningCDI || true && docker run -d -p 8080:8080 -p 4848:4848 --name LearningCDI lt.verbus/LearningCDI 
