package com.czarek.learning.java.SPOJ;

import models.ClassRoom;
import models.Pupil;
import models.Subject;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class Main {
    static ClassRoom classRoom = new ClassRoom();
    public static void main(String[] args) {

        try {
            classRoom.loadPupils();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {


           classRoom.makeTest(Subject.ENGLISH);

            System.out.println(classRoom);


        }



    }

    public static void updatePupils() {
        for (int i = 0; i < classRoom.pupilsSize(); i++) {
            classRoom.getPupil(i).updateMarks();
        }
    }
}
