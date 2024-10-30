package src.problem.baekjoon.class02_silver;

import java.util.Scanner;

class N9655_돌_게임 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();

        boolean[] dp = new boolean[1000];

        dp[0] = true;
        dp[1] = false;
        dp[2] = true;

        for (int i = 3; i < N; i++) {
            dp[i] = (!dp[i - 1] || !dp[i - 3]);
        }

        System.out.println(dp[N - 1] ? "SK" : "CY");
    }
}