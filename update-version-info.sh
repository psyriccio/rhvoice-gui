#!/bin/bash
gitstatus=$(git status --porcelain)
version=$(git describe --tags --always)

if ! [[ -z $gitstatus ]]; then
    version="$version""-SNAPSHOT"
fi

if [[ "$1" != "auto" ]]; then
    if ! [[ -z $gitstatus ]]; then
        printf "[1;31m%s[0m[1;37m%s[0m" "Rly?! Update version info on durty repo?" "[yes/NO]?"
        answer="no"
        read answer
        if [[ "$answer" == "yes" ]] || [[ "$answer" == "YES" ]] || [[ "$answer" == "Yes" ]]; then
            printf "[1;31m(durty state!)[0m\n[1;33mVersion update not be commited and repository tag not be updated![0m\n"
        else
            printf "%s" $answer
            exit 0
        fi
    fi
fi

short_version=$(echo "$version" | grep -oE "[^.]+\.[^.]+\.[^.]+\.[^.]+" | sed -E -e 's/(alpha|beta|gamma)//g')

sed -i -E -e 's/(\/\*VERSION_START_MARKER_TAG\*\/[[:space:]]*\")[[:print:]]*(\"\/\*VERSION_END_MARKER_TAG\*\/)/\1'"$version"'\2/g' ./src/buildinfo/BuildInfo.java

if [[ -z $gitstatus ]]; then
    git add src/buildinfo/BuildInfo.java
    curdate=$(date +%Y%m%d_%H%M%S)
    git commit -m "version info update $curdate"
    git tag -f -m "\"$version\"" $version
fi
