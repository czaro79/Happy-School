package models;

public enum Subject {
    BIOLOGY(0), CHEMISTRY(1), ENGLISH(2), FRENCH(3), MATHEMATICS(4), PHYSICS(5);

    private int value;
    Subject(int value) {
        this.value = value;
    }

    private void setValue(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
