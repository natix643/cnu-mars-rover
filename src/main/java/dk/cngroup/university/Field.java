package dk.cngroup.university;

public enum Field {
    ACCESSIBLE("."),
    INACCESSIBLE("0");

    private String printChar;

    Field(String printChar) {
        this.printChar = printChar;
    }

    @Override
    public String toString() {
        return printChar;
    }
}
