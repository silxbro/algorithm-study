package src.problem.baekjoon.level23_동적_계획법_1;

import java.util.Scanner;

class N1904_01타일 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();

        int[] dp = new int[1000001];
        dp[1] = 1;
        dp[2] = 2;
        for (int n = 3; n <= 1000000; n++) {
            // (길이가 (N - 1)개일 때의 가짓수) + (길이가 (N - 2)개일 때의 가짓수)
            // (벽돌 (N - 1)개 + [1]벽돌) + (벽돌 (N - 2)개 + [00]벽돌)
            dp[n] = (dp[n - 1] + dp[n - 2]) % 15746;
        }

        System.out.println(dp[N]);
    }
}