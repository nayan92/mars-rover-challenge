# mars-rover-challenge

## Running
To build a runnable fat jar:
```
./gradlew jar
```
The generated jar can be found at:
```
build/libs/roverchallenge-1.0-SNAPSHOT.jar
```
Run with (tested with java 8):
```
java -jar roverchallenge-1.0-SNAPSHOT.jar <input as one long string with inputs escaped>
e.g. java -jar roverchallenge-1.0-SNAPSHOT.jar "5 5\n1 2 N\nLMLMLMLMM\n3 3 E\nMMRMMRMRRM"
```

##  Running Tests
- The functional test resides in `RoversSimulatorTest.java`
- The remaining test files contain unit tests

To run all tests:  
```
./gradlew check
```
