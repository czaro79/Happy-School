package models;

import java.util.ArrayList;

public class ClassRoom {
    ArrayList<Pupil> pupils;

    public ClassRoom() {
        this.pupils = new ArrayList<>();
    }

    public void addPupil(Pupil pupil) {
        if (!this.containsPupil(pupil)) {
            this.pupils.add(new Pupil(pupil));
            System.out.println("\nPupil added!\n");
        } else {
            System.out.println("Cannot add - a pupil is in a list.");
        }
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
//        if (pupilFirstName == null || pupilFirstName.isBlank()) {
//            throw new IllegalArgumentException("Pupil first name cannot be null/blank.");
//        }
//        if (pupilLastName == null || pupilLastName.isBlank()) {
//            throw new IllegalArgumentException("Pupil last name cannot be null/blank.");
//        }
        for (int i = 0; i < this.pupils.size(); i++) {
            if (this.pupils.get(i).getPupilFirstName().equalsIgnoreCase(pupilFirstName) && this.pupils.get(i).getPupilLastName().equalsIgnoreCase(pupilLastName)) {
                this.pupils.remove(i);
                System.out.println("\nPupil removed from the list.\n");
            }
        }
    }
}
