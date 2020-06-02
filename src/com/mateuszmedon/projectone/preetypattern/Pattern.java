package com.mateuszmedon.projectone.preetypattern;

import java.util.Scanner;

public class Pattern {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        char[][] array = new char[4][4];
        boolean hasPattern = true;
        for (int i = 0; i < 4; i++) {
            array[i] = scanner.nextLine().toCharArray();
        }

        for (int j = 0; j < 3; j++) {
            for (int k = 0; k < 3; k++) {
                char c = array[j][k];
                if (array[j][k + 1] == c && array[j + 1][k] == c && array[j + 1][k + 1] == c) {
                    hasPattern = false;
                    break;
                }
            }
        }
        System.out.println(hasPattern ? "YES" : "NO");
    }
}