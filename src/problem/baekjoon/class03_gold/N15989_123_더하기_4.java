package src.problem.baekjoon.class03_gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class N15989_123_더하기_4 {

    static long[] dp;

    public static void main(String[] args) throws IOException {
        dp = new long[10001];

        dp[0] = 1;
        for (int n = 1; n <= 3; n++) {
            for (int i = n; i <= 10000; i++) {
                dp[i] += dp[i - n];
            }
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            stb.append(dp[Integer.parseInt(br.readLine())]).append("\n");
        }
        System.out.println(stb);
    }
}