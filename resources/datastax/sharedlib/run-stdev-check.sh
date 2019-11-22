#!/usr/bin/env bash
START=$1
END=$2
BUILD=$3
BASE=$4
TOLER=$5
DSEHOST=$6
GRAFANAHOST=$7
cd ./bin/
java -Dconfig.file=./buildCheck.json -Djenkins.xmlfilepath=. -Dgrafana.start-time=${START} -Dgrafana.end-time=${END} -Djenkins.build=${BUILD} -Djenkins.baseline=${BASE} -Djenkins.stdevtolerance=${TOLER} -Ddse.host=${DSEHOST} -Dgrafana.host=${GRAFANAHOST} -jar stdevcheck

#-Djavax.net.ssl.trustStore=/path/to/client.truststore
#-Djavax.net.ssl.trustStorePassword=password123
#-Djavax.net.ssl.keyStore=/path/to/client.keystore
#-Djavax.net.ssl.keyStorePassword=password123