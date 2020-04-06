#! /bin/bash
#mvn clean install
echo $0
 
full_path=$(realpath $0)
dir_path=$(dirname $full_path) 
bin=$(dirname $dir_path )

functionalSpec="$bin/functional_spec"
echo "$functionalSpec"


cd $bin
mvn clean install

echo "$bin/target"
cd "$bin/target"
java -cp parkinglot-0.0.1-SNAPSHOT.jar com.vikram.com.parkinglot.App 

