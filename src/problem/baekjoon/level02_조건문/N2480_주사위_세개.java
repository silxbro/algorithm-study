package src.problem.baekjoon.level02_조건문;

import java.util.Scanner;

class N2480_주사위_세개 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();

        System.out.println(result(a, b, c));
    }

    private static int result(int a, int b, int c) {
        if (a == b && b == c) {
            return 10000 + a * 1000;
        }
        if (a == b || a == c) {
            return 1000 + a * 100;
        }
        if (b == c) {
            return 1000 + b * 100;
        }
        return maxValue(a, b, c) * 100;
    }

    private static int maxValue(int a, int b, int c) {
        return Math.max(a, Math.max(b, c));
    }

}