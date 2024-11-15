package src.problem.baekjoon.class03_gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class N2169_로봇_조종하기 {

    static int N, M;
    static int[][] map;
    static int[][] dp;
    static boolean[][] visited;
    static int[] dr = {1, 0, 0};
    static int[] dc = {0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        dp = new int[N][M];
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            Arrays.fill(dp[i], Integer.MIN_VALUE);
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visited[0][0] = true;
        System.out.println(dfs(0, 0));
    }

    private static int dfs(int i, int j) {
        if (i == N - 1 && j == M - 1) {
            return map[N - 1][M - 1];
        }
        if (dp[i][j] != Integer.MIN_VALUE) {
            return dp[i][j];
        }

        for (int d = 0; d < 3; d++) {
            int nextR = i + dr[d];
            int nextC = j + dc[d];
            if (nextR >= 0 && nextR < N && nextC >= 0 && nextC < M && !visited[nextR][nextC]) {
                visited[nextR][nextC] = true;
                dp[i][j] = Math.max(dp[i][j], dfs(nextR, nextC) + map[i][j]);
                visited[nextR][nextC] = false;
            }
        }
        return dp[i][j];
    }
}