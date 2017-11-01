package dk.cngroup.university;

import static dk.cngroup.university.Field.ACCESSIBLE;

public enum Action {

    LEFT("L") {
        @Override
        public Rover updateRover(Rover rover, Landscape landscape) {
            return new Rover(rover.getPosition(), rover.getDirection().getLeft());
        }
    },

    RIGHT("R") {
        @Override
        public Rover updateRover(Rover rover, Landscape landscape) {
            return new Rover(rover.getPosition(), rover.getDirection().getRight());
        }
    },

    FORWARD("F") {
        @Override
        public Rover updateRover(Rover rover, Landscape landscape) {
            Position newPosition = rover.getPosition().getNeighbor(rover.getDirection());

            if (landscape.getField(newPosition) == ACCESSIBLE) {
                return new Rover(newPosition, rover.getDirection());
            } else {
                return rover;
            }
        }
    },

    BACKWARD("B") {
        @Override
        public Rover updateRover(Rover rover, Landscape landscape) {
            Direction oppositeDirection = rover.getDirection().getRight().getRight();
            Position newPosition = rover.getPosition().getNeighbor(oppositeDirection);

            if (landscape.getField(newPosition) == ACCESSIBLE) {
                return new Rover(newPosition, rover.getDirection());
            } else {
                return rover;
            }
        }
    };

    public abstract Rover updateRover(Rover rover, Landscape landscape);

    private final String symbol;

    Action(String symbol) {
        this.symbol = symbol;
    }

    public static Action parse(String symbol) {
        for (Action action : values()) {
            if (action.symbol.equals(symbol)) {
                return action;
            }
        }
        throw new IllegalArgumentException("no action exists for symbol: " + symbol);
    }
}
