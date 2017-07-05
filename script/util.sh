#!/usr/bin/env bash

# in order to use this file, copy or link it to parent folder
# MicroServiceTutorial/script -> MicroServiceTutorial

export POSTGRES_VERSION=9.6.3-alpine
export CONFIG_VERSION=1.0
export REST_VERSION=1.0

declare CONTEXT=$(pwd)
declare COMMAND=$1

ln -s ${CONTEXT}/config/script/* ${CONTEXT}/config
ln -s ${CONTEXT}/rest/script/* ${CONTEXT}/rest

build_all() {
    # https://stackoverflow.com/questions/8818119/how-can-i-run-a-function-from-a-script-in-command-line
    (cd ${CONTEXT}/config; . ./mvn_util.sh && package ${CONFIG_VERSION})
    (cd ${CONTEXT}/rest; . ./mvn_util.sh && package ${REST_VERSION})
}

run_all() {
    export POSTGRES_USER=postgres
    export POSTGRES_PASSWORD=root
    export POSTGRES_DB=rest_db
    export CONFIG_SERVICE_PASSWORD=123456

    docker-compose up -d
}

clean_all() {
    # remove related container
    docker rm -fv $(docker ps -a | awk ' /'microservicetutorial'/ {print $1} ')
    # remove related volume
    # docker volume rm microservicetutorial_rest_postgres_dbstore
}

build() {
    (cd ${CONTEXT}/$1; . ./mvn_util.sh && package $2)
}

clean() {
    docker rm -fv $(docker ps -a | awk ' /'microservicetutorial_$1'/ {print $1} ')
}

#if [ ${COMMAND} == 'build_all' ]; then
#    build_all
#elif [ ${COMMAND} == 'run_all' ]; then
#    run_all
#elif [ ${COMMAND} == 'build' ]; then
#    if [ $# -ne 3  ]; then
#        echo 'must pass service name and version'
#        exit
#    else
#        build $1 $2
#    fi
#else
#    echo 'supported command are: run_all'
#fi