package com.mateuszmedon.projectone.exercise;

import java.util.Optional;

public class Main {

    public static void main(String[] args) {


//        for (DayOfWeek day : DayOfWeek.values()) {
//            System.out.println(day);

    }
}
    enum DangerLevel {
        HIGH(3),
        MEDIUM(2),
        LOW(1);

        int level;

        DangerLevel(int level) {
            this.level = level;
        }

        public int getNumber() {
            return level;
        }
    }