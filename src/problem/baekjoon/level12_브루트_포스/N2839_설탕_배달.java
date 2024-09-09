package src.problem.baekjoon.level12_브루트_포스;

import java.util.Scanner;

class N2839_설탕_배달 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();

        int min = Integer.MAX_VALUE;

        for (int i = 0; i <= N / 5; i++) {
            if ((N - 5 * i) % 3 != 0) {
                continue;
            }
            min = Math.min(min, i + (N - 5 * i) / 3);
        }
        if (min == Integer.MAX_VALUE) {
            System.out.println(-1);
            return;
        }
        System.out.println(min);
    }
}