package models;

import java.util.*;

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
        this.pupilMarks.put(Subject.BIOLOGY, new ArrayList<Double>());
        this.pupilMarks.put(Subject.MATHEMATICS, new ArrayList<Double>());
        this.pupilMarks.put(Subject.FRENCH, new ArrayList<Double>());
        this.pupilMarks.put(Subject.PHYSICS, new ArrayList<Double>());
        this.pupilMarks.put(Subject.CHEMISTRY, new ArrayList<Double>());
    }

    public Pupil(Pupil source) {
        this.pupilFirstName = source.pupilFirstName;
        this.pupilLastName = source.pupilLastName;

        this.pupilMarks = new HashMap<Subject, ArrayList<Double>>();
        this.pupilMarks.put(Subject.ENGLISH, (ArrayList<Double>) source.pupilMarks.get(Subject.ENGLISH).clone());
        this.pupilMarks.put(Subject.BIOLOGY, (ArrayList<Double>) source.pupilMarks.get(Subject.BIOLOGY).clone());
        this.pupilMarks.put(Subject.MATHEMATICS, (ArrayList<Double>) source.pupilMarks.get(Subject.MATHEMATICS).clone());
        this.pupilMarks.put(Subject.FRENCH, (ArrayList<Double>) source.pupilMarks.get(Subject.FRENCH).clone());
        this.pupilMarks.put(Subject.PHYSICS, (ArrayList<Double>) source.pupilMarks.get(Subject.PHYSICS).clone());
        this.pupilMarks.put(Subject.CHEMISTRY, (ArrayList<Double>) source.pupilMarks.get(Subject.CHEMISTRY).clone());
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

    public void addMark(Subject subject, double mark) {
        this.pupilMarks.get(subject).add(mark);
    }

    public double getAverageGrade(Subject subject) {
        if (this.pupilMarks.get(subject).isEmpty()) {
            throw new IllegalStateException("Cannot calculate average grade - no marks yet.");
        }
        double sumOfMarks = 0;
        double numberOfMarks = this.pupilMarks.get(subject).size();
        for (int i = 0; i < numberOfMarks; i++) {
            sumOfMarks += this.pupilMarks.get(subject).get(0);
        }
        return sumOfMarks / numberOfMarks;

    }

    public boolean equals(Pupil object) {
        return this.pupilFirstName.equalsIgnoreCase(object.getPupilFirstName()) && this.pupilLastName.equalsIgnoreCase(object.getPupilLastName());
    }

    public String toString() {
        String temp = "Pupil: " + getPupilFirstName() + " " + getPupilLastName() + "\n";
        int firstLineLength = temp.length();
        for (int i = 1; i < firstLineLength; i++) {
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
