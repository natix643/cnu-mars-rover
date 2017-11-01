package dk.cngroup.university;

import java.util.Arrays;
import java.util.Objects;

public class Landscape {

    private final Field[][] fields;

    public Landscape(Field[][] fields) {
        this.fields = Objects.requireNonNull(fields);
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

    /**
     * @return field at given position, if inside this landscape; null if it's outside
     */
    public Field getField(Position position) {
        int x = position.getX();
        int y = position.getY();

        if (x >= 0 && x < fields.length) {
            Field[] row = fields[x];
            if (y >= 0 && y < row.length) {
                return row[y];
            }
        }

        return null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Landscape)) {
            return false;
        }

        Landscape that = (Landscape) o;
        return Arrays.deepEquals(this.fields, that.fields);
    }

    @Override
    public int hashCode() {
        return Arrays.deepHashCode(fields);
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
