package nayan92.roverchallenge;

import nayan92.roverchallenge.exception.RoverOutOfBoundsException;
import nayan92.roverchallenge.exception.UnsupportedInstructionException;

public class Entrypoint {

    public static void main(String[] args) throws UnsupportedInstructionException, RoverOutOfBoundsException {
        RoversSimulator simulator = new RoversSimulator();
        String output = simulator.simulate("5 5\n1 2 N\nLMLMLMLMM\n3 3 E\nMMRMMRMRRM");
        System.out.println(output);
    }

}
