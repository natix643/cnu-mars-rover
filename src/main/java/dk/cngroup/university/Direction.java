package dk.cngroup.university;

public enum Direction {
    NORTH(WorldSide.EAST, WorldSide.WEST),
    EAST(WorldSide.SOUTH, WorldSide.NORTH),
    SOUTH(WorldSide.WEST, WorldSide.EAST),
    WEST(WorldSide.NORTH, WorldSide.SOUTH);

    private WorldSide rightOf;
    private WorldSide leftOf;

    Direction(WorldSide rightOf, WorldSide leftOf) {
        this.rightOf = rightOf;
        this.leftOf = leftOf;
    }

    public Direction getRightOf() {
        return DirectionFactory.getDirection(rightOf);
    }

    public Direction getLeftOf() {
        return DirectionFactory.getDirection(leftOf);
    }
}
