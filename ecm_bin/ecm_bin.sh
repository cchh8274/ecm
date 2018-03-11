#!/usr/bin/env bash
SERVER_PATH=/app/server/
SERVER_NM=payment-eurekaserver-1.0-SNAPSHOT.jar
SERVER_PORT=9001
JAVA_OPT="-Xms2048m -Xmx2048m"
LOGFILE=/dev/null
PIDFILE=/dev/null


if [ "$1" = "start" ] ; then
    echo date
    date
    echo ========startup===
    nohup java -jar ${SERVER_PATH}${SERVER_NM} --server.port=${SERVER_PORT} ${JAVA_OPT} >> ${LOGFILE} &
    echo date
    date
    ID=`ps -ef | grep java |grep ${SERVER_PATH}|grep ${SERVER_NM}|grep ${SERVER_PORT}|awk '{print $2}'`
    echo ${ID} > ${PIDFILE}
    echo ========sccess====

elif [ "$1" = "stop" ]; then
    echo date
    date
    echo =============shut down ======
    echo ------kill
    ID=`ps -ef | grep java |grep ${SERVER_PATH}|grep ${SERVER_NM}|grep ${SERVER_PORT}|awk '{print $2}'`
    echo $ID
    echo "---------------"
    for id in $ID
    do
      kill $id
      echo "killed $id"
    done
    echo "---------------"

    sleep 5s
    echo =============force shut down ======
    ID=`ps -ef | grep java |grep ${SERVER_PATH}|grep ${SERVER_NM}|grep ${SERVER_PORT}|awk '{print $2}'`
    echo $ID
    echo "---------------"
    for id in $ID
    do
      kill -9 $id
      echo "killed$id"
    done
    echo "---------------"

elif [ "$1" = "restart" ]; then
    echo date
    date
    echo =============shut down ======
    echo ------kill
    ID=`ps -ef | grep java |grep ${SERVER_PATH}|grep ${SERVER_NM}|grep ${SERVER_PORT}|awk '{print $2}'`
    echo $ID
    echo "---------------"
    for id in $ID
    do
      kill $id
      echo "killed $id"
    done
    echo "---------------"

    sleep 5s
    echo =============force shut down ======
    ID=`ps -ef | grep java |grep ${SERVER_PATH}|grep ${SERVER_NM}|grep ${SERVER_PORT}|awk '{print $2}'`
    echo $ID
    echo "---------------"
    for id in $ID
    do
      kill -9 $id
      echo "killed$id"
    done
    echo "---------------"


    echo ========startup===
    nohup java -jar ${SERVER_PATH}${SERVER_NM} --server.port=${SERVER_PORT} ${JAVA_OPT} >> ${LOGFILE} &
    echo date
    date
    ID=`ps -ef | grep java |grep ${SERVER_PATH}|grep ${SERVER_NM}|grep ${SERVER_PORT}|awk '{print $2}'`
    echo ${ID} > ${PIDFILE}
    echo ========sccess====
fi