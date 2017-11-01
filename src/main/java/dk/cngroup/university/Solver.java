package dk.cngroup.university;

import java.util.List;
import java.util.Set;

import static dk.cngroup.university.Field.ACCESSIBLE;

public class Solver {

    private final Camera camera = new Camera();
    private final Input input;
    private final Position finalPosition;

    public Solver(List<String> inputLines) {
        this.input = Input.parse(inputLines);
        this.finalPosition = findFinalPosition();
    }

    private Position findFinalPosition() {
        Rover rover = input.getInitialRover();

        for (Action action : input.getActions()) {
            rover = action.updateRover(rover, input.getLandscape());
            camera.onAction(rover, input.getLandscape());
        }
        return rover.getPosition();
    }

    public boolean isInitialPositionValid() {
        Position position = input.getInitialRover().getPosition();
        return input.getLandscape().getField(position) == ACCESSIBLE;
    }

    public boolean isTargetPositionValid() {
        Position position = input.getTargetPosition();
        return input.getLandscape().getField(position) == ACCESSIBLE;
    }

    public Set<Position> getFoundObstacles() {
        return camera.getObstacles();
    }

    public Input getInput() {
        return input;
    }

    public Position getFinalPosition() {
        return finalPosition;
    }
}
