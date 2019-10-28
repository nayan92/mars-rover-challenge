package nayan92.roverchallenge;

import nayan92.roverchallenge.exception.InvalidDirectionException;
import nayan92.roverchallenge.exception.RoverOutOfBoundsException;
import nayan92.roverchallenge.exception.UnsupportedInstructionException;
import nayan92.roverchallenge.math.DirectionUtils;
import nayan92.roverchallenge.math.data.Coord;
import nayan92.roverchallenge.math.data.Position;

public class NewPositionStrategy {

    private final DirectionUtils directionUtils;

    public NewPositionStrategy() {
        directionUtils = new DirectionUtils();
    }

    public Position calculate(Coord upperRight, Position currentPosition, char nextMove) throws UnsupportedInstructionException, RoverOutOfBoundsException {
        switch (nextMove) {
            case 'L':
                return new Position(currentPosition.getPoint(), directionUtils.turnLeft(currentPosition.getDirection()));
            case 'R':
                return new Position(currentPosition.getPoint(), directionUtils.turnRight(currentPosition.getDirection()));
            case 'M':
                return new Position(calculateNextCoordAfterOneStep(upperRight, currentPosition), currentPosition.getDirection());
            default:
                throw new UnsupportedInstructionException();
        }
    }

    private Coord calculateNextCoordAfterOneStep(Coord upperRight, Position currentPosition) throws RoverOutOfBoundsException {
        Coord nextPoint;

        switch (currentPosition.getDirection()) {
            case NORTH:
                nextPoint = new Coord(currentPosition.getPoint().getX(), currentPosition.getPoint().getY() + 1);
                if (nextPoint.getY() > upperRight.getY())
                    throw new RoverOutOfBoundsException();
                return nextPoint;
            case EAST:
                nextPoint = new Coord(currentPosition.getPoint().getX() + 1, currentPosition.getPoint().getY());
                if (nextPoint.getX() > upperRight.getX())
                    throw new RoverOutOfBoundsException();
                return nextPoint;
            case SOUTH:
                nextPoint = new Coord(currentPosition.getPoint().getX(), currentPosition.getPoint().getY() - 1);
                if (nextPoint.getY() < 0)
                    throw new RoverOutOfBoundsException();
                return nextPoint;
            case WEST:
                nextPoint = new Coord(currentPosition.getPoint().getX() - 1, currentPosition.getPoint().getY());
                if (nextPoint.getX() < 0)
                    throw new RoverOutOfBoundsException();
                return nextPoint;
            default:
                throw new InvalidDirectionException();
        }
    }

}
