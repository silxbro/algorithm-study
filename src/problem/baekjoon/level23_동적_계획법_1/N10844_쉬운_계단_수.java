package src.problem.baekjoon.level23_동적_계획법_1;

import java.util.Scanner;

class N10844_쉬운_계단_수 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[][] dp = new int[101][10];

        for (int i = 1; i <= 9; i++) {
            dp[1][i] = 1;
        }

        for (int i = 2; i <= N; i++) {
            dp[i][0] = dp[i - 1][1];
            dp[i][9] = dp[i - 1][8];
            for (int j = 1; j < 9; j++) {
                dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % 1000000000;
            }
        }

        int answer = 0;
        for (int count : dp[N]) {
            answer = (answer + count) % 1000000000;
        }
        System.out.println(answer);
    }
}