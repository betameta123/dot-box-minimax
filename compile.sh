#!/usr/bin/env bash

rm -r bin/*.class
javac src/*.java -d bin/

java -cp bin/ Game


