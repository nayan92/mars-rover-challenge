package nayan92.roverchallenge.io;

import nayan92.roverchallenge.io.exception.InvalidRoverPositionException;
import nayan92.roverchallenge.io.exception.InvalidUpperRightCoordException;
import nayan92.roverchallenge.io.exception.MissingRoverInstructionsException;
import nayan92.roverchallenge.math.data.Coord;
import nayan92.roverchallenge.math.data.Position;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static nayan92.roverchallenge.math.data.Direction.EAST;
import static nayan92.roverchallenge.math.data.Direction.NORTH;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.samePropertyValuesAs;

public class InputParserTest {

    @Rule public ExpectedException thrown = ExpectedException.none();

    private InputParser inputParser = new InputParser();

    @Test
    public void should_parse_upper_right_coordinates_from_first_line_of_input() {
        String input = "5 6";

        SimulationParameters parameters = inputParser.parse(input);

        assertThat(parameters.getUpperRight(), samePropertyValuesAs(new Coord(5, 6)));
    }

    @Test
    public void should_throw_invalid_upper_right_coord_exception_when_x_coordinate_for_upper_right_is_unparseable() {
        String input = "X 6";

        thrown.expect(InvalidUpperRightCoordException.class);

        inputParser.parse(input);
    }

    @Test
    public void should_throw_invalid_upper_right_coord_exception_when_y_coordinate_for_upper_right_is_unparseable() {
        String input = "5 Y";

        thrown.expect(InvalidUpperRightCoordException.class);

        inputParser.parse(input);
    }

    @Test
    public void should_throw_invalid_upper_right_coord_exception_when_not_enough_values_provided_to_build_a_coordinate() {
        String input = "5";

        thrown.expect(InvalidUpperRightCoordException.class);

        inputParser.parse(input);
    }

    @Test
    public void should_throw_invalid_upper_right_coord_exception_when_x_coord_is_negative() {
        String input = "-5 5";

        thrown.expect(InvalidUpperRightCoordException.class);

        inputParser.parse(input);
    }

    @Test
    public void should_throw_invalid_upper_right_coord_exception_when_y_coord_is_negative() {
        String input = "5 -5";

        thrown.expect(InvalidUpperRightCoordException.class);

        inputParser.parse(input);
    }

    @Test
    public void empty_rover_parameters_should_return_empty_list() {
        String input = "5 6";

        SimulationParameters parameters = inputParser.parse(input);

        assertThat(parameters.getRoverParameters(), hasSize(0));
    }

    @Test
    public void rover_coordinates_and_instructions_are_parsed_correctly_for_all_rovers() {
        String input = "5 6\n1 2 N\nLRM\n3 4 E\nMRM";

        SimulationParameters parameters = inputParser.parse(input);

        RoverParameters expectedRover1 = new RoverParameters(new Position(new Coord(1, 2), NORTH), "LRM");
        RoverParameters expectedRover2 = new RoverParameters(new Position(new Coord(3, 4), EAST), "MRM");
        assertThat(parameters.getRoverParameters().get(0), samePropertyValuesAs(expectedRover1));
        assertThat(parameters.getRoverParameters().get(1), samePropertyValuesAs(expectedRover2));
    }

    @Test
    public void should_throw_invalid_rover_position_exception_when_x_coordinate_unparseable_for_rover() {
        String input = "5 6\nX 2 N\nLRM";

        thrown.expect(InvalidRoverPositionException.class);

        inputParser.parse(input);
    }

    @Test
    public void should_throw_invalid_rover_position_exception_when_y_coordinate_unparseable_for_rover() {
        String input = "5 6\n1 Y N\nLRM";

        thrown.expect(InvalidRoverPositionException.class);

        inputParser.parse(input);
    }

    @Test
    public void should_throw_invalid_rover_position_exception_when_x_coordinate_is_negative_for_rover() {
        String input = "5 6\n-1 1 N\nLRM";

        thrown.expect(InvalidRoverPositionException.class);

        inputParser.parse(input);
    }

    @Test
    public void should_throw_invalid_rover_position_exception_when_y_coordinate_is_negative_for_rover() {
        String input = "5 6\n1 -1 N\nLRM";

        thrown.expect(InvalidRoverPositionException.class);

        inputParser.parse(input);
    }

    @Test
    public void should_throw_invalid_rover_position_exception_when_direction_unparseable_for_rover() {
        String input = "5 6\n1 2 Q\nLRM";

        thrown.expect(InvalidRoverPositionException.class);

        inputParser.parse(input);
    }

    @Test
    public void should_throw_invalid_rover_position_exception_when_not_enough_values_provided_to_build_a_position() {
        String input = "5 6\n1\nLRM";

        thrown.expect(InvalidRoverPositionException.class);

        inputParser.parse(input);
    }

    @Test
    public void should_throw_missing_rover_instructions_exception_when_instructions_are_missing() {
        String input = "5 6\n1 2 N";

        thrown.expect(MissingRoverInstructionsException.class);

        inputParser.parse(input);
    }

}