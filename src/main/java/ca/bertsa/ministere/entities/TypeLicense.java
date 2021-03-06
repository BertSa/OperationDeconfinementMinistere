package ca.bertsa.ministere.entities;

import java.util.List;
import java.util.Random;

public enum TypeLicense {
    VACCINE, NEGATIVETEST;
    private static final List<TypeLicense> VALUES =
            List.of(values());
    private static final int SIZE = VALUES.size();
    private static final Random RANDOM = new Random();

    @Override
    public String toString() {
        return super.name();
    }

    public static TypeLicense randomType() {
        return VALUES.get(RANDOM.nextInt(SIZE));
    }
}