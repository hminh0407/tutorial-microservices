#!/usr/bin/env bash

source docker_config.sh

declare DOCKER_SERVICE=${1:-"all"}

if [ ${DOCKER_SERVICE} != "all" ] && [ ${DOCKER_SERVICE} != "postgres" ] && [ ${DOCKER_SERVICE} != "web" ]; then
    echo 'Supported docker service are: "postgres", "web" and ""'
    exit
fi

if [ ${DOCKER_SERVICE} == "all" ]; then
    docker-compose up -d
else
    docker-compose up -d ${DOCKER_SERVICE}
fi