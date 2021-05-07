package ca.bertsa.ministere.entities;

public enum TypeLicense {
    Vaccine, NegativeTest;

    @Override
    public String toString() {
        return super.name();
    }
}
