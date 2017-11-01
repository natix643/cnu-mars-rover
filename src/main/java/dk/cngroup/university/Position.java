package dk.cngroup.university;

import java.util.Objects;

public class Position {
    private final int x;
    private final int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public static Position parse(String string) {
        String[] parts = string.split(",");
        if (parts.length != 2) {
            throw new IllegalArgumentException(string);
        }

        return new Position(
                Integer.parseInt(parts[0]),
                Integer.parseInt(parts[1])
        );
    }

    public Position getNeighbor(Direction direction) {
        switch (direction) {
            case NORTH:
                return new Position(x - 1, y);
            case EAST:
                return new Position(x, y + 1);
            case SOUTH:
                return new Position(x + 1, y);
            case WEST:
                return new Position(x, y - 1);
            default:
                throw new IllegalArgumentException("invalid direction:" + direction);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Position)) {
            return false;
        }

        Position that = (Position) o;
        return this.x == that.x
                && this.y == that.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return x + "," + y;
    }
}
