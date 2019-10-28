package nayan92.roverchallenge;

import nayan92.roverchallenge.exception.RoverOutOfBoundsException;
import nayan92.roverchallenge.exception.UnsupportedInstructionException;
import nayan92.roverchallenge.io.PositionPrinter;
import nayan92.roverchallenge.io.InputParser;
import nayan92.roverchallenge.io.RoverParameters;
import nayan92.roverchallenge.io.SimulationParameters;
import nayan92.roverchallenge.math.DirectionUtils;
import nayan92.roverchallenge.math.data.Coord;
import nayan92.roverchallenge.math.data.Position;

import java.util.*;
import java.util.stream.Collectors;

public class RoversSimulator {

    private final InputParser inputParser;
    private final NewPositionStrategy newPositionStrategy;
    private final PositionPrinter positionPrinter;

    public RoversSimulator() {
        inputParser = new InputParser();
        newPositionStrategy = new NewPositionStrategy();
        positionPrinter = new PositionPrinter(new DirectionUtils());
    }

    public String simulate(String input) throws UnsupportedInstructionException, RoverOutOfBoundsException {
        SimulationParameters simulationParameters = inputParser.parse(input);
        Coord upperRight = simulationParameters.getUpperRight();
        List<RoverParameters> rovers = simulationParameters.getRoverParameters();


        List<Position> finalPositions = new ArrayList<>();
        for (RoverParameters roverParameters : rovers) {
            Position finalRoverPosition = simulateRover(upperRight, roverParameters);
            finalPositions.add(finalRoverPosition);
        }

        return finalPositions.stream()
                .map(positionPrinter::apply)
                .collect(Collectors.joining("\n"));
    }

    private Position simulateRover(Coord upperRight, RoverParameters rover) throws UnsupportedInstructionException, RoverOutOfBoundsException {
        Position initialPosition = rover.getInitialPosition();
        String instructions = rover.getInstructions();

        Position currentPosition = initialPosition;
        for (char instruction : instructions.toCharArray()) {
            currentPosition = newPositionStrategy.calculate(upperRight, currentPosition, instruction);
        }

        return currentPosition;
    }

}
