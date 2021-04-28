package ca.bertsa.ministere.entities;

public enum TypeLicense {
    Vaccine, Negative_Test;

    @Override
    public String toString() {
        return super.name();
    }
}
