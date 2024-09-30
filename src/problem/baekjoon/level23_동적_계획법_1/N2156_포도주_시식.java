package src.problem.baekjoon.level23_동적_계획법_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class N2156_포도주_시식 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] q = new int[10001];
        for (int i = 1; i <= n; i++) {
            q[i] = Integer.parseInt(br.readLine());
        }

        int[] dp = new int[10001];


        dp[1] = q[1];
        dp[2] = q[1] + q[2];
        int maxQ = dp[2];
        for (int i = 3; i <= n; i++) {
            // 해당 포도주를 선택하지 않는 경우를 생각하지 못함
            dp[i] = Math.max(dp[i - 1], (Math.max(dp[i - 3] + q[i - 1], dp[i - 2]) + q[i]));
            maxQ = Math.max(maxQ, dp[i]);
        }
        if (n == 1) {
            maxQ = dp[1];
        }
        System.out.println(maxQ);
    }
}