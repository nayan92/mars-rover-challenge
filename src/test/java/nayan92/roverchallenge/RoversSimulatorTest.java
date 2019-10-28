package nayan92.roverchallenge;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class RoversSimulatorTest {

    private RoversSimulator simulator = new RoversSimulator();

    @Test
    public void outputs_the_expected_result_for_the_provided_example() throws Exception {
        String output = simulator.simulate("5 5\n1 2 N\nLMLMLMLMM\n3 3 E\nMMRMMRMRRM");

        assertThat(output, equalTo("1 3 N\n5 1 E"));
    }

}