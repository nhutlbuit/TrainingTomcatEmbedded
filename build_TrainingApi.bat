echo off
title Building Training System...
color 2
cd TrainingModel
mvn clean install && ^
color b && ^
echo Done for TrainingModel built! && ^
cd ..\TrainingApi && ^
mvn install -DskipTests  && ^
echo Done all! && ^
pause
