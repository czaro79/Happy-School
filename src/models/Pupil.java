package models;

import java.util.Arrays;

public class Pupil {
    private String pupilName;
    private final int[][] pupilGradingLog;

    public Pupil(String pupilName, int[][] logs) {
        if (pupilName == null || pupilName.isBlank()) {
            throw new IllegalArgumentException("Pupil must have a name! - cannot be null/blank)");
        }
        this.pupilName = pupilName;
        this.pupilGradingLog = Arrays.copyOf(logs, logs.length);
    }

    public Pupil(Pupil source) {
        this.pupilName = source.pupilName;
        this.pupilGradingLog = Arrays.copyOf(source.pupilGradingLog, source.pupilGradingLog.length);
    }

    public String getPupilName() {
        return pupilName;
    }

    public void setPupilName(String pupilName) {
        if (pupilName == null || pupilName.isBlank()) {
            throw new IllegalArgumentException("Pupil must have a name! - cannot be null/blank)");
        }
        this.pupilName = pupilName;
    }

    public String toString() {
        StringBuilder temp = new StringBuilder("Name: " + pupilName + "\n");

        for (int[] ints : pupilGradingLog) {
            for (int anInt : ints) {
                temp.append(anInt).append(" ");
            }
            temp.append("\n");
        }

        temp.append("\n");

        return temp.toString();
    }
}
