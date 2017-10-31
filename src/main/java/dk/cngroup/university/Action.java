package dk.cngroup.university;

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
            throw new UnsupportedOperationException();
        }
    },

    BACKWARD("B") {
        @Override
        public Rover updateRover(Rover rover, Landscape landscape) {
            throw new UnsupportedOperationException();
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
