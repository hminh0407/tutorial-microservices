#!/usr/bin/env bash

package () {
    export CONFIG_VERSION=${1:-1.0-SNAPSHOT}

    mvn clean package -e
}