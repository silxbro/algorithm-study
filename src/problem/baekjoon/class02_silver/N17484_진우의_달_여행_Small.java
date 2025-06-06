package src.problem.baekjoon.class02_silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class N17484_진우의_달_여행_Small {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] map = new int[N + 1][M];
        int[][][] dp = new int[N + 1][M][3];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                Arrays.fill(dp[i][j], Integer.MAX_VALUE);
            }
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 0; j < M; j++) {
                if (j - 1 >= 0) {
                    dp[i][j][2] = Math.min(dp[i][j][2], Math.min(dp[i - 1][j - 1][0], dp[i - 1][j - 1][1]) + map[i][j]);
                }
                if (j + 1 < M) {
                    dp[i][j][0] = Math.min(dp[i][j][0], Math.min(dp[i - 1][j + 1][1], dp[i - 1][j + 1][2]) + map[i][j]);
                }
                dp[i][j][1] = Math.min(dp[i][j][1], Math.min(dp[i - 1][j][0], dp[i - 1][j][2]) + map[i][j]);
            }
        }

        int answer = dp[N][0][0];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < 3; j++) {
                answer = Math.min(answer, dp[N][i][j]);
            }
        }

        System.out.println(answer);
    }
}