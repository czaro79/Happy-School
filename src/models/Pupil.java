package models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Pupil {
    private String pupilFirstName;
    private String pupilLastName;
    HashMap<Subject, ArrayList<Double>> pupilMarks;

    public Pupil(String pupilFirstName, String pupilLastName) {
        if (pupilFirstName == null || pupilFirstName.isBlank()) {
            throw new IllegalArgumentException("Pupil must have a first name! - cannot be null/blank)");
        }
        if (pupilLastName == null || pupilLastName.isBlank()) {
            throw new IllegalArgumentException("Pupil must have a last name! - cannot be null/blank)");
        }
        this.pupilFirstName = pupilFirstName;
        this.pupilLastName = pupilLastName;
        this.pupilMarks = new HashMap<Subject, ArrayList<Double>>();

        this.pupilMarks.put(Subject.ENGLISH, new ArrayList<Double>());
        this.pupilMarks.put(Subject.BIOLOGY,new ArrayList<Double>());
        this.pupilMarks.put(Subject.MATHEMATICS, new ArrayList<Double>());
        this.pupilMarks.put(Subject.FRENCH, new ArrayList<Double>());
        this.pupilMarks.put(Subject.PHYSICS, new ArrayList<Double>());
        this.pupilMarks.put(Subject.CHEMISTRY, new ArrayList<Double>());
    }

    public Pupil(Pupil source) {
        this.pupilFirstName = source.pupilFirstName;
        this.pupilLastName = source.pupilLastName;
        this.pupilMarks = (HashMap<Subject, ArrayList<Double>>) Map.copyOf(source.pupilMarks);
    }

    public String getPupilFirstName() {
        return pupilFirstName;
    }

    public String getPupilLastName() {
        return pupilLastName;
    }

    public void setPupilFirstName(String pupilFirstName) {
        if (pupilFirstName == null || pupilFirstName.isBlank()) {
            throw new IllegalArgumentException("Pupil must have a first name! - cannot be null/blank)");
        }
        this.pupilFirstName = pupilFirstName;
    }

    public void setPupilLastName(String pupilLastName) {
        if (pupilLastName == null || pupilLastName.isBlank()) {
            throw new IllegalArgumentException("Pupil must have a last name! - cannot be null/blank)");
        }
        this.pupilLastName = pupilLastName;
    }

    public String toString() {
        String temp = "Pupil: " + getPupilFirstName() + " " + getPupilLastName() + "\n";
        int firstLineLength = temp.length();
        for (int i = 0; i < firstLineLength; i++) {
            temp += "-";
        }
        temp += "\n";
        temp += Subject.ENGLISH + ": " + this.pupilMarks.get(Subject.ENGLISH).toString() + "\n" +
                Subject.BIOLOGY + ": " + this.pupilMarks.get(Subject.BIOLOGY).toString() + "\n" +
                Subject.MATHEMATICS + ": " + this.pupilMarks.get(Subject.MATHEMATICS).toString() + "\n" +
                Subject.FRENCH + ": " + this.pupilMarks.get(Subject.FRENCH).toString() + "\n" +
                Subject.PHYSICS + ": " + this.pupilMarks.get(Subject.PHYSICS).toString() + "\n" +
                Subject.CHEMISTRY + ": " + this.pupilMarks.get(Subject.CHEMISTRY).toString() + "\n\n";
        return temp;
    }
}
