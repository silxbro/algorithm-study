package src.problem.baekjoon.조건문_level02;

import java.util.Scanner;

class 오븐_시계_2525 {

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