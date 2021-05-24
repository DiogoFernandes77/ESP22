set -e

MODULES=(
	FindeThePlane
	
)

for i in ${!MODULES[@]}; do
	cd ${MODULES[$i]}
	cd complete
	
	mvn -X -Dmaven.test.skip=true --settings ../settings.xml deploy
	
done
