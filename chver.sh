#!/bin/bash
git add .
descrfilename=/tmp/$(uuidgen)
printf "%s" "$(git describe --tags --always)" > $descrfilename
nano $descrfilename
descr=$(cat $descrfilename)
git commit -m "$descr"
git push
git tag -f -m "$descr" $descr
git push --tags --force
./gradlew markLastRelease
git add lastbuild
git commit -m "$descr"
git push
#git add .
#git commit -m "$descr"
#git tag -f -m "$descr" $descr
#git push
#git push --tags --force
