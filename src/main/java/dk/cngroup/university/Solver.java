package dk.cngroup.university;

import java.util.List;

import static dk.cngroup.university.Field.ACCESSIBLE;

public class Solver {

    private final Input input;

    public Solver(List<String> inputLines) {
        this.input = Input.parse(inputLines);
    }

    public Input getInput() {
        return input;
    }

    public boolean isInitialPositionValid() {
        Position position = input.getInitialRover().getPosition();
        return input.getLandscape().getField(position) == ACCESSIBLE;
    }

    public boolean isTargetPositionValid() {
        Position position = input.getTargetPosition();
        return input.getLandscape().getField(position) == ACCESSIBLE;
    }

    public Position getFinalPosition() {
        Rover rover = input.getInitialRover();

        for (Action action : input.getActions()) {
            rover = action.updateRover(rover, input.getLandscape());
        }
        return rover.getPosition();
    }
}
