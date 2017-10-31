package dk.cngroup.university;

public enum Action {
    LEFT("L"),
    RIGHT("R"),
    FORWARD("F"),
    BACKWARD("B");

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
