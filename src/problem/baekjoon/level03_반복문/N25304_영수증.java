package src.problem.baekjoon.level03_반복문;

import java.util.Scanner;

class N25304_영수증 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int X = scanner.nextInt();
        int N = scanner.nextInt();
        int total = 0;
        for (int n = 0; n < N; n++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            total += a * b;
        }

        if (total == X) {
            System.out.println("Yes");
            return;
        }
        System.out.println("No");
    }

}