package ca.bertsa.ministere.entities;

import java.util.List;
import java.util.Random;

public enum Sex {
    MALE, FEMALE, OTHER;
    private static final List<Sex> VALUES =
            List.of(values());
    private static final int SIZE = VALUES.size();
    private static final Random RANDOM = new Random();

    @Override
    public String toString() {
        return super.name();
    }

    public static Sex randomSex() {
        return VALUES.get(RANDOM.nextInt(SIZE));
    }
}
