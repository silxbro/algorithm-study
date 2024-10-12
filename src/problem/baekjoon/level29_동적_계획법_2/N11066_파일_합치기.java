package src.problem.baekjoon.level29_동적_계획법_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class N11066_파일_합치기 {
    static int[] sum;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuffer stb = new StringBuffer();

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int K = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            sum = new int[K + 1];
            dp = new int[K + 1][K + 1];
            for (int i = 1; i <= K; i++) {
                sum[i] = sum[i - 1] + Integer.parseInt(st.nextToken());
            }

            int result = recurse(1, K);

            stb.append(result).append("\n");
        }
        System.out.println(stb);
    }

    private static int recurse(int start, int end) {
        if (dp[start][end] > 0) {
            return dp[start][end];
        }
        if (start == end) {
            return 0;
        }

        int result = Integer.MAX_VALUE;
        for (int i = 0; i < end - start; i++) {
            int middle = start + i;
            result = Math.min(result, recurse(start, middle) + recurse(middle + 1, end));
        }
        return dp[start][end] = result + (sum[end] - sum[start - 1]);
    }
}