package com.czarek.learning.java.SPOJ;

import models.Pupil;
import models.Subject;

public class Main {

    public static void main(String[] args) {
        Pupil pupil = new Pupil("Cezary","Drobiazg");

        pupil.addMark(Subject.MATHEMATICS, 4.5);
        pupil.addMark(Subject.MATHEMATICS, 3);
        pupil.addMark(Subject.BIOLOGY, 6);
        System.out.println(pupil);
        System.out.println(pupil.getAverageGrade(Subject.FRENCH));

    }
}
