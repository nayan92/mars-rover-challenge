package nayan92.roverchallenge.io;

import nayan92.roverchallenge.math.data.Coord;

import java.util.List;

import static java.util.Collections.unmodifiableList;

public final class SimulationParameters {

    private final Coord upperRight;
    private final List<RoverParameters> roverParameters;

    public SimulationParameters(Coord upperRight, List<RoverParameters> roverParameters) {
        this.upperRight = upperRight;
        this.roverParameters = unmodifiableList(roverParameters);
    }

    public Coord getUpperRight() {
        return upperRight;
    }

    public List<RoverParameters> getRoverParameters() {
        return roverParameters;
    }
}
