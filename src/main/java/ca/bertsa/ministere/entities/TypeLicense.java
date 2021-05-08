package ca.bertsa.ministere.entities;

public enum TypeLicense {
    VACCINE, NEGATIVETEST;

    @Override
    public String toString() {
        return super.name();
    }
}