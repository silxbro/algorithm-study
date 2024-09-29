package src.problem.baekjoon.level23_동적_계획법_1;

import java.util.Scanner;

class N1463_1로_만들기 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] dp = new int[1000001];

        dp[1] = 0;
        for (int i = 2; i <= N; i++) {
            dp[i] = Integer.MAX_VALUE;
            if (i % 3 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 3] + 1);
            }
            if (i % 2 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 2] + 1);
            }
            dp[i] = Math.min(dp[i], dp[i - 1] + 1);
        }
        System.out.println(dp[N]);
    }
}