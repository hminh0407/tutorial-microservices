#!/usr/bin/env bash

declare PROFILE=${1:-"container"}

if [ ${PROFILE} != "container" ]; then
    echo 'Supported profile are: "container"'
    exit
fi

source environment_${PROFILE}.sh