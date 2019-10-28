package nayan92.roverchallenge.math;

import nayan92.roverchallenge.exception.InvalidDirectionException;
import nayan92.roverchallenge.math.data.Direction;

import java.util.Arrays;
import java.util.Optional;

import static nayan92.roverchallenge.math.data.Direction.*;

public class DirectionUtils {

    public Optional<Direction> fromChar(char directionChar) {
        return Arrays.stream(Direction.values()).filter(dir -> dir.getCharRepresentation() == directionChar).findFirst();
    }

    public char toChar(Direction dir) {
        return dir.getCharRepresentation();
    }

    public Direction turnRight(Direction direction) {
        switch (direction) {
            case NORTH: return EAST;
            case EAST: return SOUTH;
            case SOUTH: return WEST;
            case WEST: return NORTH;
            default: throw new InvalidDirectionException();
        }
    }

    public Direction turnLeft(Direction direction) {
        switch (direction) {
            case NORTH: return WEST;
            case WEST: return SOUTH;
            case SOUTH: return EAST;
            case EAST: return NORTH;
            default: throw new InvalidDirectionException();
        }
    }

}
