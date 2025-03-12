package src.problem.baekjoon.class02_silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N9095_123_더하기 {

    public static void main(String[] args) throws IOException {
        int[] dp = new int[11];
        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 1;
        for (int i = 1; i < dp.length; i++) {
            for (int n = 1; n <= 3; n++) {
                if (i > n) {
                    dp[i] += dp[i - n];
                }
            }
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int n = Integer.parseInt(br.readLine());
            stb.append(dp[n]).append("\n");
        }
        System.out.println(stb);
    }
}