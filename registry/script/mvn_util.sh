#!/usr/bin/env bash

package () {
    export REGISTRY_VERSION=${1:-1.0-SNAPSHOT}

    mvn clean package -P container -e
}