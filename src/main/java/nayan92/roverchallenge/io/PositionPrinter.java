package nayan92.roverchallenge.io;

import nayan92.roverchallenge.math.DirectionUtils;
import nayan92.roverchallenge.math.data.Position;

public class PositionPrinter {

    private final DirectionUtils directionUtils;

    public PositionPrinter(DirectionUtils directionUtils) {
        this.directionUtils = directionUtils;
    }

    public String apply(Position position) {
        return position.getPoint().getX() + " "
                + position.getPoint().getY() + " "
                + directionUtils.toChar(position.getDirection());
    }

}
