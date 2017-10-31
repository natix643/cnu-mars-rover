package dk.cngroup.university;

public enum Direction {

    NORTH("N") {
        @Override
        public Direction getLeft() {
            return WEST;
        }

        @Override
        public Direction getRight() {
            return EAST;
        }
    },

    EAST("E") {
        @Override
        public Direction getLeft() {
            return NORTH;
        }

        @Override
        public Direction getRight() {
            return SOUTH;
        }
    },

    SOUTH("S") {
        @Override
        public Direction getLeft() {
            return EAST;
        }

        @Override
        public Direction getRight() {
            return WEST;
        }
    },

    WEST("W") {
        @Override
        public Direction getLeft() {
            return SOUTH;
        }

        @Override
        public Direction getRight() {
            return NORTH;
        }
    };

    // Using abstract methods allows forwards references between the enum values

    public abstract Direction getLeft();

    public abstract Direction getRight();

    private final String symbol;

    Direction(String symbol) {
        this.symbol = symbol;
    }

    public static Direction parse(String symbol) {
        for (Direction direction : values()) {
            if (direction.symbol.equals(symbol)) {
                return direction;
            }
        }
        throw new IllegalArgumentException("no direction exists for symbol: " + symbol);
    }
}
