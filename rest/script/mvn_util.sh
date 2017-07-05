#!/usr/bin/env bash

package () {
    export REST_VERSION=${1:-1.0-SNAPSHOT}
    export POSTGRES_VERSION=9.6.3-alpine

    export DB_HOST=localhost
    export DB_PORT=5432
    export POSTGRES_USER=postgres
    export POSTGRES_PASSWORD=root
    export POSTGRES_DB=rest_db

    # start up db, db connect are required to build this service
    docker-compose up -d postgres
    sleep 3
    mvn clean package -P container -e
}