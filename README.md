## ntask

### Task

task 1. Please write the java code for the following task - we need to calculate height of a tree when given its root node. Please design your own classes. We don’t need tree rebalancing etc. Just the basic class(es) sufficient to represent the tree and be able to calculate the height. Feel free to make any assumptions. If you have time please provide unit test. Max time limit is 30 minutes to complete.
Надеюсь на вашу честность относительно времени выполнения.

task 2. Remove from a list numbers that duplicate 3 and more times in a row. Remove from a list numbers that duplicate 3 and more times in any order.

### Build

run `./gradlew clean build`

then executable jars for each task could be found in the following directories `./ntask/task1/build/libs` and `./ntask/task2/build/libs` 

### Run

to run a jar execute following command `java -jar task*-1.0.jar "path to the input data file""`

jars expect the input data to be presented in json format, for examples see files `task1.json` and `task2.json`

you can omit the parameter to the input data file, then each jar would expect it to be presented at its directory named `task1.json` and `task2.json` respectively   