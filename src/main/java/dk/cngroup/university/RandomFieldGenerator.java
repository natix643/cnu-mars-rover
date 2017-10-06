package dk.cngroup.university;

import java.util.Random;

public class RandomFieldGenerator {

    private static final int THRESHOLD = 10;

    private Random random = new Random();

    public Field getRandomField() {
        if (random.nextInt(100) < THRESHOLD) {
            return Field.INACCESSIBLE;
        } else {
            return Field.ACCESSIBLE;
        }
    }
}

