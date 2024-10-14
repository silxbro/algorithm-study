package src.problem.baekjoon.level34_동적_계획법과_최단거리_역추적;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class N12852_1로_만들기_2 {

    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        dp = new int[N + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[1] = 0;

        for (int i = 2; i <= N; i++) {
            if (i % 3 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 3] + 1);
            }
            if (i % 2 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 2] + 1);
            }
            dp[i] = Math.min(dp[i], dp[i - 1] + 1);
        }

        StringBuilder stb = new StringBuilder();
        stb.append(dp[N]).append("\n");
        int index = N;
        while (index >= 1) {
            stb.append(index).append(" ");
            if (index % 3 == 0 && dp[index / 3] == dp[index] - 1) {
                index /= 3;
            } else if (index % 2 == 0 && dp[index / 2] == dp[index] - 1) {
                index /= 2;
            } else {
                index--;
            }
        }
        System.out.println(stb);
    }
}