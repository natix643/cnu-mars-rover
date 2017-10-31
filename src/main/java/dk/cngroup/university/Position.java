package dk.cngroup.university;

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

    public boolean isInsideLandscape(int landscapeWidth) {
        if (this.getX() < 0
                || this.getY() < 0) {
            return false;
        }

        if (this.getX() >= landscapeWidth) {
            return false;
        }
        if (this.getY() >= landscapeWidth) {
            return false;
        }

        return true;
    }
}
