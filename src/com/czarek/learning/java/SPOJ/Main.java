package com.czarek.learning.java.SPOJ;

import models.ClassRoom;
import models.Pupil;
import models.Subject;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class Main {

    public static void main(String[] args) {
        Pupil pupil = new Pupil("Cezary", "Drobiazg");
//        Pupil pupil1 = new Pupil(pupil);
//        Pupil pupil2 = pupil;
//        pupil1.setPupilFirstName("Pawel");
//
        ClassRoom classRoom = new ClassRoom();
//        classRoom.addPupil(pupil);
//
//        classRoom.addPupil(pupil2);
//
//        System.out.println(pupil.equals(pupil1));
//        classRoom.removePupil("Cezary", "Drobiazg");
//        classRoom.addPupil(pupil);
//
//        classRoom.makeTest(Subject.MATHEMATICS);
//        classRoom.makeTest(Subject.MATHEMATICS);
//        classRoom.makeTest(Subject.MATHEMATICS);
//        classRoom.makeTest(Subject.BIOLOGY);
//        classRoom.makeTest(Subject.PHYSICS);

        try {
            classRoom.loadPupils();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            System.out.println(classRoom);
            classRoom.

            for (int i = 0; i < classRoom; i++) {

            }
        }



    }
}
