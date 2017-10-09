#!/bin/bash
git add .
descrfilename=/tmp/$(uuidgen)
printf "%s" "-- update tag: $(git describe --tags --abbrev=0)" > $descrfilename
nano $descrfilename
descr=$(cat $descrfilename)
git commit -m "$descr"
git push
git tag -f -m "$(git describe --tags --abbrev=0)" $(git describe --tags --abbrev=0)
git push --tags --force