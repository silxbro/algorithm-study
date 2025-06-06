package src.problem.baekjoon.level02_조건문;

import java.util.Scanner;

class N2884_알람_시계 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int hour = scanner.nextInt();
        int minute = scanner.nextInt();

        minute -= 45;

        if (minute < 0) {
            if (hour == 0) {
                hour = 24;
            }
            hour--;
            minute += 60;
        }

        System.out.println(hour + " " + minute);
    }

}