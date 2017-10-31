package dk.cngroup.university;

public enum Field {
    ACCESSIBLE("."),
    INACCESSIBLE("0");

    private String symbol;

    Field(String symbol) {
        this.symbol = symbol;
    }

    public static Field parse(String symbol) {
        for (Field field : values()) {
            if (field.symbol.equals(symbol)) {
                return field;
            }
        }
        throw new IllegalArgumentException("no field exists for symbol: " + symbol);
    }

    @Override
    public String toString() {
        return symbol;
    }
}
