package dk.cngroup.university;

import static java.util.Objects.requireNonNull;

public class Rover {
    private final Position position;
    private final Direction direction;

    public Rover(Position position, Direction direction) {
        this.position = requireNonNull(position);
        this.direction = requireNonNull(direction);
    }

    public Position getPosition() {
        return position;
    }

    public Direction getDirection() {
        return direction;
    }
}
