package dk.cngroup.university;

public class Landscape {

    private Field[][] landscape;

    public Landscape(Field[][] landscape) {
        this.landscape = landscape;
    }

    public Landscape(RandomFieldGenerator generator, int squareSize) {
        this.landscape = createLandscape(generator, squareSize);
    }

    private Field[][] createLandscape(RandomFieldGenerator generator, int squareSize) {
        Field[][] landscape = new Field[squareSize][squareSize];
        for (int i = 0; i < squareSize; i++) {
            for (int j = 0; j < squareSize; j++) {
                landscape[i][j] = generator.getRandomField();
            }
        }
        return landscape;
    }

    public Field[][] getLandscape() {
        return landscape;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Field[] row : landscape) {
            for (Field field : row) {
                sb.append(field);
            }
            sb.append("\n");
        }

        return sb.toString();
    }

    public boolean isFieldAccessible(RoverPosition pos) {
        if (pos.getX() < 0
                || pos.getY() < 0) {
            return false;
        }

        if (pos.getX() >= landscape.length) {
            return false;
        }
        if (pos.getY() >= landscape.length) {
            return false;
        }

        Field field = landscape[pos.getX()][pos.getY()];

        return field == Field.ACCESSIBLE;
    }
}