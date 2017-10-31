package dk.cngroup.university;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Rover)) {
            return false;
        }

        Rover that = (Rover) o;
        return this.position.equals(that.position)
                && this.direction == that.direction;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, direction);
    }

    @Override
    public String toString() {
        return String.format("(%s %s)", position, direction);
    }
}
