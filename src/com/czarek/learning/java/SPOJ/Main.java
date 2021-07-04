package com.czarek.learning.java.SPOJ;

import models.ClassRoom;
import models.Pupil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class Main {

    public static void main(String[] args) {
        Pupil pupil = new Pupil("Cezary","Drobiazg");
        Pupil pupil1 = new Pupil(pupil);
        Pupil pupil2 = pupil;
        pupil1.setPupilFirstName("Pawel");

        ClassRoom classRoom = new ClassRoom();
        classRoom.addPupil(pupil);

        classRoom.addPupil(pupil2);

        System.out.println(pupil.equals(pupil1));
        classRoom.removePupil("Cezary", "Drobiazg");
        classRoom.removePupil("Tomasz" ,"Kkk");

    }
}
