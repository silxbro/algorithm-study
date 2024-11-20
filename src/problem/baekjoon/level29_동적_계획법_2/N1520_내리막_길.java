package src.problem.baekjoon.level29_동적_계획법_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class N1520_내리막_길 {

    static int M, N;
    static int[][] map;
    static int[][] dp;
    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new int[M][N];
        dp = new int[M][N];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = -1;
            }
        }
        System.out.println(dfs(0, 0));
    }

    private static int dfs(int i, int j) {
        if (i == M - 1 && j == N - 1) {
            return 1;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        dp[i][j] = 0;
        for (int d = 0; d < 4; d++) {
            int nextI = i + dr[d];
            int nextJ = j + dc[d];
            if (nextI >= 0 && nextI < M && nextJ >= 0 && nextJ < N && map[i][j] > map[nextI][nextJ]) {
                dp[i][j] += dfs(nextI, nextJ);
            }
        }
        return dp[i][j];
    }
}