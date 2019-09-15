## ntask

### Build

run `./gradlew clean build`

then executable jars for each task could be found in the following directories `./ntask/task1/build/libs` and `./ntask/task2/build/libs` 

### Run

to run a jar execute following command `java -jar task*-1.0.jar "path to the input data file""`

jars expect the input data to be presented in json format, for examples see files `task1.json` and `task2.json`

you can omit the parameter to the input data file, then each jar would expect it to be presented at its directory named `task1.json` and `task2.json` respectively   