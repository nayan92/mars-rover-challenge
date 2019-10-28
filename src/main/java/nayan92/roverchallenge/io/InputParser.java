package nayan92.roverchallenge.io;

import nayan92.roverchallenge.io.exception.InvalidRoverPositionException;
import nayan92.roverchallenge.io.exception.InvalidUpperRightCoordException;
import nayan92.roverchallenge.io.exception.MissingRoverInstructionsException;
import nayan92.roverchallenge.math.DirectionUtils;
import nayan92.roverchallenge.math.data.Coord;
import nayan92.roverchallenge.math.data.Direction;
import nayan92.roverchallenge.math.data.Position;

import java.util.ArrayList;
import java.util.List;

public class InputParser {

    private final DirectionUtils directionUtils;

    public InputParser() {
        directionUtils = new DirectionUtils();
    }

    public SimulationParameters parse(String input) {
        String[] lines = input.split("\n");

        Coord upperRight = parseUpperRightCoord(lines);
        List<RoverParameters> roverParameters = parseRoverParameters(lines);

        return new SimulationParameters(upperRight, roverParameters);
    }

    private Coord parseUpperRightCoord(String[] lines) {
        String[] parsedLine = lines[0].split(" ");
        if (parsedLine.length != 2) {
            throw new InvalidUpperRightCoordException();
        }

        try {
            int x = Integer.parseInt(parsedLine[0]);
            int y = Integer.parseInt(parsedLine[1]);

            if (x < 0 || y < 0) {
                throw new InvalidUpperRightCoordException();
            }

            return new Coord(x, y);
        } catch(NumberFormatException e) {
            throw new InvalidUpperRightCoordException();
        }
    }

    private List<RoverParameters> parseRoverParameters(String[] lines) {
        List<RoverParameters> parameters = new ArrayList<>();
        for (int i = 1; i < lines.length; i += 2) {
            Position position = parsePosition(lines[i]);
            if (i + 1 >= lines.length) {
                throw new MissingRoverInstructionsException();
            }
            String instructions = lines[i + 1];
            parameters.add(new RoverParameters(position, instructions));
        }
        return parameters;
    }

    private Position parsePosition(String line) {
        String[] parsedLine = line.split(" ");
        if (parsedLine.length != 3) {
            throw new InvalidRoverPositionException();
        }

        try {
            int x = Integer.parseInt(parsedLine[0]);
            int y = Integer.parseInt(parsedLine[1]);
            Direction direction = directionUtils.fromChar(parsedLine[2].charAt(0)).orElseThrow(InvalidRoverPositionException::new);

            if (x < 0 || y < 0) {
                throw new InvalidRoverPositionException();
            }

            return new Position(new Coord(x, y), direction);
        } catch(NumberFormatException e) {
            throw new InvalidRoverPositionException();
        }
    }

}
