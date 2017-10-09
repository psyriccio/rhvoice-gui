#!/bin/bash
./gradlew clean
./gradlew mkRelease
rm -f ./RHVoice-gui.jar
cp ./$(cat ./lastbuild) ./RHVoice-gui.jar
