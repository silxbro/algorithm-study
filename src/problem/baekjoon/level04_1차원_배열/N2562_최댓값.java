package src.problem.baekjoon.level04_1차원_배열;

import java.util.Scanner;

class N2562_최댓값 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int max = Integer.MIN_VALUE;
        int order = 0;
        for (int n = 1; n <= 9; n++) {
            int now = scanner.nextInt();
            if (now > max) {
                max = now;
                order = n;
            }
        }

        System.out.println(max);
        System.out.println(order);
    }
}