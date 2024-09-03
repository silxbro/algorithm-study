package src.problem.baekjoon.level02_조건문;

import java.util.Scanner;

class N2753_윤년 {

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