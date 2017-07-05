#!/usr/bin/env bash

# remove related container
docker rm -fv $(docker ps | awk ' /'resttutorial'/ {print $1} ')

# remove related volume
docker volume rm resttutorial_rest_postgres_dbstore