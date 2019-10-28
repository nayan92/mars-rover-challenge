package nayan92.roverchallenge.io;

import nayan92.roverchallenge.math.data.Position;

public final class RoverParameters {

    private final Position initialPosition;
    private final String instructions;

    public RoverParameters(Position initialPosition, String instructions) {
        this.initialPosition = initialPosition;
        this.instructions = instructions;
    }


    public Position getInitialPosition() {
        return initialPosition;
    }

    public String getInstructions() {
        return instructions;
    }
}
