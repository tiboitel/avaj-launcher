#!/usr/bin/env bash
javac -d ./src -sourcepath . `find -L . -name "*.java"`
