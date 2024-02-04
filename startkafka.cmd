@echo off
set /p zookeeperPath=Enter the path to the Zookeeper directory: 

if "%zookeeperPath%"=="" (
    echo Please provide a valid path.
    goto :eof
)

cd /d %zookeeperPath%
.\bin\windows\kafka-server-start.bat .\config\server.properties
