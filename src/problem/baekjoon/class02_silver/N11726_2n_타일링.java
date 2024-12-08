package src.problem.baekjoon.class02_silver;

import java.util.Scanner;

class N11726_2n_타일링 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int[] dp = new int[1001];

        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= 1000; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 10007;
        }

        System.out.println(dp[n]);
    }
}