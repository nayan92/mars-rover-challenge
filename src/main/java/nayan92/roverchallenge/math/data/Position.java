package nayan92.roverchallenge.math.data;

public final class Position {

    private final Coord point;
    private final Direction direction;

    public Position(Coord point, Direction direction) {
        this.point = point;
        this.direction = direction;
    }

    public Coord getPoint() {
        return point;
    }

    public Direction getDirection() {
        return direction;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Position))
            return super.equals(obj);

        Position other = (Position) obj;

        return this.point.equals(other.getPoint()) && this.direction == other.getDirection();
    }
}
