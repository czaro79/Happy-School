package com.czarek.learning.java.SPOJ;

import models.ClassRoom;
import models.Pupil;
import models.Subject;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    static ClassRoom classRoom = new ClassRoom();

    public static void main(String[] args) {

        try {
            classRoom.loadPupils();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            classRoom.updateClass();
            manageClass();
        }


    }

    public static void updatePupils() {
        for (int i = 0; i < classRoom.pupilsSize(); i++) {
            classRoom.getPupil(i).updateMarks();
        }
    }

    public static void manageClass() {
        Scanner scan = new Scanner(System.in);

        while (true) {
            System.out.println("Witamy w naszej klasie.");
            System.out.println("Wybierz jakie operacje chcesz wykonac:");
            System.out.println("\t1 - pokaz cala klase");
            System.out.println("\t2 - pokaz wybranego ucznia");
            System.out.println("\t3 - robimy sprawdzian w klasie");
            System.out.println("\t4 - pokaz srednia ocen ucznia");
            System.out.println("\t5 - KONIEC\n\n");
            System.out.println("Wybieram: ");

            int response = scan.hasNextInt() ? scan.nextInt() : 404;
            scan.nextLine();
            if (response == 404) {
                continue;
            }

            switch (response) {
                case 1:
                    System.out.println(classRoom);
                    System.out.println("Press ENTER key to continue.");
                    scan.nextLine();
                    continue;
                case 2:
                    while (true) {
                        System.out.println("Oceny ktorego ucznie chce zobaczyc?");
                        System.out.print("Wpisz imie: ");
                        String firstName = scan.nextLine();
                        if (firstName.isBlank()) {
                            continue;
                        }
                        System.out.print("Wpisz nazwisko: ");
                        String lastName = scan.nextLine();
                        if (lastName.isBlank()) {
                            continue;
                        }
                        System.out.println("\n" + classRoom.getPupil(firstName, lastName));
                        System.out.println("Press ENTER key to continue.");
                        scan.nextLine();
                        break;
                    }
                case 3:
                    System.out.print("Z jakiego przedmiotu robimy sprawdzian: ");
                    System.out.println("MATHEMATICS, PHYSICS, ENGLISH, FRENCH, BIOLOGY, CHEMISTRY");
                    System.out.print("Wybieram: ");
                    String subject = scan.nextLine();
                    switch (subject) {
                        case "MATHEMATICS":
                            classRoom.makeTest(Subject.MATHEMATICS);
                            break;

                        case "PHYSICS":
                            classRoom.makeTest(Subject.PHYSICS);
                            break;
                        case "ENGLISH":
                            classRoom.makeTest(Subject.ENGLISH);
                            break;
                        case "FRENCH":
                            classRoom.makeTest(Subject.FRENCH);
                            break;
                        case "BIOLOGY":
                            classRoom.makeTest(Subject.BIOLOGY);
                            break;
                        case "CHEMISTRY":
                            classRoom.makeTest(Subject.CHEMISTRY);
                    }
                    System.out.println("Sprawdzian zakonczony, oceny wpisane!\n");
                    continue;
                case 4:
                    while (true) {
                        System.out.println("Srednia ocen ktorego ucznie chce zobaczyc?");
                        System.out.print("Wpisz imie: ");
                        String firstName = scan.nextLine();
                        if (firstName.isBlank()) {
                            System.out.println();
                            continue;
                        }
                        System.out.print("Wpisz nazwisko: ");
                        String lastName = scan.nextLine();
                        if (lastName.isBlank()) {
                            System.out.println();
                            continue;
                        }
                        System.out.println("\nSrednia ucznia " + firstName + " " + lastName + " wynosi:\n");
                        System.out.println("MATHEMATICS: " + classRoom.getPupil(firstName, lastName).getAverageGrade(Subject.MATHEMATICS));
                        System.out.println("BIOLOGY: " + classRoom.getPupil(firstName, lastName).getAverageGrade(Subject.BIOLOGY));
                        System.out.println("PHYSICS: " + classRoom.getPupil(firstName, lastName).getAverageGrade(Subject.PHYSICS));
                        System.out.println("FRENCH: " + classRoom.getPupil(firstName, lastName).getAverageGrade(Subject.FRENCH));
                        System.out.println("CHEMISTRY: " + classRoom.getPupil(firstName, lastName).getAverageGrade(Subject.CHEMISTRY));
                        System.out.println("ENGLISH: " + classRoom.getPupil(firstName, lastName).getAverageGrade(Subject.ENGLISH));
                        System.out.println("Press ENTER key to continue.");
                        scan.nextLine();
                        break;
                    }
                default:
                    break;
            }
            scan.close();
        }
    }
}
