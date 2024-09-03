package src.problem.baekjoon.level02_조건문;

import java.util.Scanner;

class N2525_오븐_시계 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int hour = scanner.nextInt();
        int minute = scanner.nextInt();
        int time = scanner.nextInt();

        int totalMinutes = hour * 60 + minute + time;
        hour = totalMinutes / 60 % 24;
        minute = totalMinutes % 60;
        System.out.println(hour + " " + minute);
    }

}