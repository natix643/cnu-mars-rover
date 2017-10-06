package dk.cngroup.university;

public class DirectionFactory {

    public static Direction getDirection(WorldSide side) {
        switch (side) {
            case NORTH:
                return Direction.NORTH;
            case EAST:
                return Direction.EAST;
            case WEST:
                return Direction.WEST;
            case SOUTH:
                return Direction.SOUTH;
        }
        //should never happen
        throw new RuntimeException("unkown worldside value");
    }
}
