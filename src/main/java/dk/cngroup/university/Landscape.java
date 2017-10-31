package dk.cngroup.university;

public class Landscape {

    private final Field[][] fields;

    public Landscape(Field[][] fields) {
        this.fields = fields;
    }

    public Landscape(FieldGenerator generator, int squareSize) {
        this.fields = generateFields(generator, squareSize);
    }

    private Field[][] generateFields(FieldGenerator generator, int squareSize) {
        Field[][] fields = new Field[squareSize][squareSize];
        for (int i = 0; i < squareSize; i++) {
            for (int j = 0; j < squareSize; j++) {
                fields[i][j] = generator.getRandomField();
            }
        }
        return fields;
    }

    public Field[][] getFields() {
        return fields;
    }

    public boolean isFieldAccessible(Position pos) {
        if (!pos.isInsideLandscape(fields.length)) {
            return false;
        }

        Field field = fields[pos.getX()][pos.getY()];
        return field == Field.ACCESSIBLE;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < fields.length; i++) {
            Field[] row = fields[i];
            for (Field field : row) {
                sb.append(field);
            }
            if (i < fields.length - 1) {
                sb.append("\n");
            }
        }
        return sb.toString();
    }
}
