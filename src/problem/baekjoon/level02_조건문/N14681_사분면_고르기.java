package src.problem.baekjoon.level02_조건문;

import java.util.Scanner;

class N14681_사분면_고르기 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        int y = scanner.nextInt();

        if (x > 0 && y > 0) {
            System.out.println("1");
            return;
        }
        if (x < 0 && y > 0) {
            System.out.println("2");
            return;
        }
        if (x < 0 && y < 0) {
            System.out.println("3");
            return;
        }

        System.out.println("4");
    }

}