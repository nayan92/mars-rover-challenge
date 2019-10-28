package nayan92.roverchallenge.math.data;

public final class Coord {

    private final int x;
    private final int y;

    public Coord(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Coord))
            return super.equals(obj);

        Coord other = (Coord) obj;

        return this.x == other.getX() && this.y == other.getY();
    }
}
