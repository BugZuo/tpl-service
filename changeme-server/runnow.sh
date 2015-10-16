#! /bin/bash

options=""
debugPort=5005

while getopts "p:d" arg
do
        case $arg in
            p)
                debugPort="$OPTARG"
                ;;
            d)
                options="-Xdebug -Xrunjdwp:transport=dt_socket,server=y,suspend=y,address=$debugPort"
                ;;
            ?)
            echo "unkonw argument"
        exit 1
        ;;
        esac
done

mvn clean
mvn spring-boot:run -Drun.jvmArguments="$options"

