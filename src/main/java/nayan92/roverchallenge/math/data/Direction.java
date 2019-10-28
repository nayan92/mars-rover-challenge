package nayan92.roverchallenge.math.data;

public enum Direction {

    NORTH('N'),
    EAST('E'),
    SOUTH('S'),
    WEST('W');

    private final char charRepresentation;

    Direction(char charRepresentation) {
        this.charRepresentation = charRepresentation;
    }

    public char getCharRepresentation() {
        return charRepresentation;
    }
}
