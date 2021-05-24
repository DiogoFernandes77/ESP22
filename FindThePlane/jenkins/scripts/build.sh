#!/bin/bash
set -e

cd ${FindThePlane/complete}
ls

mvn -X -Dmaven.test.skip=true --settings ../settings.xml deploy

	


