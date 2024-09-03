package src.problem.baekjoon.조건문_level02;

import java.util.Scanner;

class 윤년_2753 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int year = scanner.nextInt();
        if (isLeapYear(year)) {
            System.out.println("1");
            return;
        }
        System.out.println("0");
    }

    private static boolean isLeapYear(int year) {
        if (year % 4 != 0) {
            return false;
        }
        return year % 100 != 0 || year % 400 == 0;
    }
}