#!/bin/bash
set -e

cd ${FindThePlane}
ls

mvn -X -Dmaven.test.skip=true --settings ../settings.xml deploy

	


