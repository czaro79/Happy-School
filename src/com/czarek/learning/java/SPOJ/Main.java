package com.czarek.learning.java.SPOJ;

import models.Pupil;

public class Main {

    public static void main(String[] args) {
        int[][] tableOfLogs = new int[][]{
                {2, 3, 4, 5, 3},
                {5, 4, 5, 6, 5},
                {4, 5, 4, 4, 5},
                {2, 3, 2, 4, 5},
                {3, 4, 5, 5, 5},
                {3, 4, 2, 2, 5}};

        int[][] tab = new int[6][4];

        Pupil pupil = new Pupil("Czarek Drobiazg", tableOfLogs);

        System.out.println(pupil);
        pupil.setPupilName("");
        System.out.println(pupil.getPupilName());
    }
}
