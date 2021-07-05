package models;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ClassRoom {
    public static ArrayList<Pupil> pupils;

    public ClassRoom() {
        pupils = new ArrayList<>();
    }

    public void addPupil(Pupil pupil) {
        if (!this.containsPupil(pupil)) {
            pupils.add(pupil);
        }
    }

    public Pupil getPupil(String pupilFirstName, String pupilLastName) {

        for (Pupil pupil : pupils) {
            if (pupil.equals(pupilFirstName, pupilLastName)) {
                return new Pupil(pupil);
            }
        }
        return null;
    }

    public Pupil getPupil(int index) {
        return pupils.get(index);
    }

    public int pupilsSize() {
        return pupils.size();
    }

    public boolean containsPupil(Pupil object) {
        if (object == null) {
            throw new IllegalArgumentException("Illegal null value to check pupil in the classroom.");
        }
        for (Pupil pupil : pupils) {
            return pupil.getPupilFirstName().equalsIgnoreCase(object.getPupilFirstName()) && pupil.getPupilLastName().equalsIgnoreCase(object.getPupilLastName());
        }
        return false;
    }

    public boolean containsPupil(String pupilFirstName, String pupilLastName) {
        if (pupilFirstName == null || pupilFirstName.isBlank()) {
            throw new IllegalArgumentException("Pupil first name cannot be null/blank.");
        }
        if (pupilLastName == null || pupilLastName.isBlank()) {
            throw new IllegalArgumentException("Pupil last name cannot be null/blank.");
        }
        for (Pupil pupil : pupils) {
            return pupil.getPupilFirstName().equalsIgnoreCase(pupilFirstName) && pupil.getPupilLastName().equalsIgnoreCase(pupilLastName);
        }
        return false;
    }

    public void removePupil(String pupilFirstName, String pupilLastName) {
        if (pupilFirstName == null || pupilFirstName.isBlank()) {
            throw new IllegalArgumentException("Pupil first name cannot be null/blank.");
        }
        if (pupilLastName == null || pupilLastName.isBlank()) {
            throw new IllegalArgumentException("Pupil last name cannot be null/blank.");
        }
        for (int i = 0; i < pupils.size(); i++) {
            if (pupils.get(i).getPupilFirstName().equalsIgnoreCase(pupilFirstName) && pupils.get(i).getPupilLastName().equalsIgnoreCase(pupilLastName)) {
                pupils.remove(i);
                System.out.println("\nPupil removed from the list.\n");
            }
        }
    }

    public void updateClass() {
        for (Pupil pupil : pupils
        ) {
            pupil.updateMarks();
        }
    }

    public void makeTest(Subject subject) {

        for (Pupil pupil : pupils) {
            pupil.addMark(subject, pupil.randomMark());
        }
    }

    public void loadPupils() throws FileNotFoundException {

        FileInputStream fis = new FileInputStream("src/models/pupils.txt");
        Scanner scan = new Scanner(fis);

        while (scan.hasNextLine()) {
            String[] pupilsNames = scan.nextLine().split(",");
            for (String pupilsName : pupilsNames) {
                String[] pupilName = pupilsName.split(" ");
                this.addPupil(new Pupil(pupilName[0], pupilName[1]));
            }
        }
        scan.close();
    }

    public String toString() {
        String temp = "";

        for (Pupil pupil : pupils) {
            temp += pupil.toString();
        }

        return temp;
    }


}
