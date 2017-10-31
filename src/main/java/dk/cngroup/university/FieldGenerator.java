package dk.cngroup.university;

import java.util.Random;

import static dk.cngroup.university.Field.ACCESSIBLE;
import static dk.cngroup.university.Field.INACCESSIBLE;

public class FieldGenerator {

    private static final int THRESHOLD = 10;

    private final Random random = new Random();

    public Field getRandomField() {
        return random.nextInt(100) < THRESHOLD ? INACCESSIBLE : ACCESSIBLE;
    }
}
