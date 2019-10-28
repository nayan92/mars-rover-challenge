package nayan92.roverchallenge;

import nayan92.roverchallenge.exception.RoverOutOfBoundsException;
import nayan92.roverchallenge.exception.UnsupportedInstructionException;
import nayan92.roverchallenge.math.data.Coord;
import nayan92.roverchallenge.math.data.Position;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static nayan92.roverchallenge.math.data.Direction.*;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class NewPositionStrategyTest {

    @Rule public ExpectedException thrown = ExpectedException.none();

    private NewPositionStrategy newPositionStrategy = new NewPositionStrategy();

    @Test
    public void when_next_move_is_turn_left_then_the_rovers_direction_should_be_updated_and_coordinate_remains_the_same() throws UnsupportedInstructionException, RoverOutOfBoundsException {
        Coord upperRight = new Coord(5, 5);
        Position currentPosition = new Position(new Coord(2, 2), NORTH);

        Position newPosition = newPositionStrategy.calculate(upperRight, currentPosition, 'L');

        assertThat(newPosition.getDirection(), equalTo(WEST));
        assertThat(newPosition.getPoint(), equalTo(currentPosition.getPoint()));
    }

    @Test
    public void when_next_move_is_turn_right_then_the_rovers_direction_should_be_updated_and_coordinate_remains_the_same() throws UnsupportedInstructionException, RoverOutOfBoundsException {
        Coord upperRight = new Coord(5, 5);
        Position currentPosition = new Position(new Coord(2, 2), NORTH);

        Position newPosition = newPositionStrategy.calculate(upperRight, currentPosition, 'R');

        assertThat(newPosition.getDirection(), equalTo(EAST));
        assertThat(newPosition.getPoint(), equalTo(currentPosition.getPoint()));
    }

    @Test
    public void when_next_move_is_unknown_then_throw_unsupported_instruction_exception() throws UnsupportedInstructionException, RoverOutOfBoundsException {
        Coord upperRight = new Coord(5, 5);
        Position currentPosition = new Position(new Coord(2, 2), NORTH);

        thrown.expect(UnsupportedInstructionException.class);

        newPositionStrategy.calculate(upperRight, currentPosition, 'X');
    }

    @Test
    public void when_direction_is_north_and_instruction_is_to_move_forward_then_rover_coordinate_should_be_updated_and_direction_remains_the_same() throws UnsupportedInstructionException, RoverOutOfBoundsException {
        Coord upperRight = new Coord(5, 5);
        Position currentPosition = new Position(new Coord(2, 2), NORTH);

        Position newPosition = newPositionStrategy.calculate(upperRight, currentPosition, 'M');

        assertThat(newPosition.getPoint(), equalTo(new Coord(2, 3)));
        assertThat(newPosition.getDirection(), equalTo(NORTH));
    }

    @Test
    public void when_direction_is_east_and_instruction_is_to_move_forward_then_rover_coordinate_should_be_updated_and_direction_remains_the_same() throws UnsupportedInstructionException, RoverOutOfBoundsException {
        Coord upperRight = new Coord(5, 5);
        Position currentPosition = new Position(new Coord(2, 2), EAST);

        Position newPosition = newPositionStrategy.calculate(upperRight, currentPosition, 'M');

        assertThat(newPosition.getPoint(), equalTo(new Coord(3, 2)));
        assertThat(newPosition.getDirection(), equalTo(EAST));
    }

    @Test
    public void when_direction_is_south_and_instruction_is_to_move_forward_then_rover_coordinate_should_be_updated_and_direction_remains_the_same() throws UnsupportedInstructionException, RoverOutOfBoundsException {
        Coord upperRight = new Coord(5, 5);
        Position currentPosition = new Position(new Coord(2, 2), SOUTH);

        Position newPosition = newPositionStrategy.calculate(upperRight, currentPosition, 'M');

        assertThat(newPosition.getPoint(), equalTo(new Coord(2, 1)));
        assertThat(newPosition.getDirection(), equalTo(SOUTH));
    }

    @Test
    public void when_direction_is_west_and_instruction_is_to_move_forward_then_rover_coordinate_should_be_updated_and_direction_remains_the_same() throws UnsupportedInstructionException, RoverOutOfBoundsException {
        Coord upperRight = new Coord(5, 5);
        Position currentPosition = new Position(new Coord(2, 2), WEST);

        Position newPosition = newPositionStrategy.calculate(upperRight, currentPosition, 'M');

        assertThat(newPosition.getPoint(), equalTo(new Coord(1, 2)));
        assertThat(newPosition.getDirection(), equalTo(WEST));
    }

    @Test
    public void when_direction_is_north_and_rover_is_at_edge_of_map_and_instruction_is_to_move_forward_then_throw_out_of_bounds_exception() throws UnsupportedInstructionException, RoverOutOfBoundsException {
        Coord upperRight = new Coord(5, 5);
        Position currentPosition = new Position(new Coord(0, 5), NORTH);

        thrown.expect(RoverOutOfBoundsException.class);

        newPositionStrategy.calculate(upperRight, currentPosition, 'M');
    }

    @Test
    public void when_direction_is_east_and_rover_is_at_edge_of_map_and_instruction_is_to_move_forward_then_throw_out_of_bounds_exception() throws UnsupportedInstructionException, RoverOutOfBoundsException {
        Coord upperRight = new Coord(5, 5);
        Position currentPosition = new Position(new Coord(5, 0), EAST);

        thrown.expect(RoverOutOfBoundsException.class);

        newPositionStrategy.calculate(upperRight, currentPosition, 'M');
    }

    @Test
    public void when_direction_is_south_and_rover_is_at_edge_of_map_and_instruction_is_to_move_forward_then_throw_out_of_bounds_exception() throws UnsupportedInstructionException, RoverOutOfBoundsException {
        Coord upperRight = new Coord(5, 5);
        Position currentPosition = new Position(new Coord(0, 0), SOUTH);

        thrown.expect(RoverOutOfBoundsException.class);

        newPositionStrategy.calculate(upperRight, currentPosition, 'M');
    }

    @Test
    public void when_direction_is_west_and_rover_is_at_edge_of_map_and_instruction_is_to_move_forward_then_throw_out_of_bounds_exception() throws UnsupportedInstructionException, RoverOutOfBoundsException {
        Coord upperRight = new Coord(5, 5);
        Position currentPosition = new Position(new Coord(0, 0), WEST);

        thrown.expect(RoverOutOfBoundsException.class);

        newPositionStrategy.calculate(upperRight, currentPosition, 'M');
    }

}