package models;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ClassRoom {
    ArrayList<Pupil> pupils;

    public ClassRoom() {
        this.pupils = new ArrayList<>();
    }

    public void addPupil(Pupil pupil) {
        if (!this.containsPupil(pupil)) {
            this.pupils.add(pupil);
        }
    }

    public Pupil getPupil(String pupilFirstName, String pupilLastName) {

        for (Pupil pupil : this.pupils) {
            if (pupil.equals(pupilFirstName, pupilLastName)) {
                return new Pupil(pupil);
            }
        }
        return null;
    }

    public boolean containsPupil(Pupil object) {
        if (object == null) {
            throw new IllegalArgumentException("Illegal null value to check pupil in the classroom.");
        }
        for (Pupil pupil : this.pupils) {
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
        for (Pupil pupil : this.pupils) {
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
        for (int i = 0; i < this.pupils.size(); i++) {
            if (this.pupils.get(i).getPupilFirstName().equalsIgnoreCase(pupilFirstName) && this.pupils.get(i).getPupilLastName().equalsIgnoreCase(pupilLastName)) {
                this.pupils.remove(i);
                System.out.println("\nPupil removed from the list.\n");
            }
        }
    }



    public void makeTest(Subject subject) {

        for (Pupil pupil : this.pupils) {
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

        for (Pupil pupil : this.pupils) {
            temp += pupil.toString();
        }

        return temp;
    }




}
