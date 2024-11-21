package src.problem.baekjoon.class03_gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class N14500_테르로미노 {

    static int N, M;
    static int[][] map;
    static boolean[][] visited;
    static int[] dr = {0, 0, 1, -1};
    static int[] dc = {1, -1, 0, 0};
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                getMaxSum(i, j);
            }
        }
        System.out.println(answer);
    }

    private static void getMaxSum(int a, int b) {
        if (a > 0 && b > 0 && b < M - 1) {
            answer = Math.max(answer, map[a][b] + map[a - 1][b] + map[a][b - 1] + map[a][b + 1]);
        }
        if (a < N - 1 && b > 0 && b < M - 1) {
            answer = Math.max(answer, map[a][b] + map[a + 1][b] + map[a][b - 1] + map[a][b + 1]);
        }
        if (a > 0 && a < N - 1 && b > 0) {
            answer = Math.max(answer, map[a][b] + map[a - 1][b] + map[a + 1][b] + map[a][b - 1]);
        }
        if (a > 0 &&a < N - 1 && b < M - 1) {
            answer = Math.max(answer, map[a][b] + map[a - 1][b] + map[a + 1][b] + map[a][b + 1]);
        }
        visited[a][b] = true;
        dfs(a, b, 1, map[a][b]);
        visited[a][b] = false;
    }

    private static void dfs(int a, int b, int count, int sum) {
        if (count == 4) {
            answer = Math.max(answer, sum);
            return;
        }
        for (int d = 0; d < 4; d++) {
            int nextR = a + dr[d];
            int nextC = b + dc[d];
            if (nextR >= 0 && nextR < N && nextC >= 0 && nextC < M && !visited[nextR][nextC]) {
                visited[nextR][nextC] = true;
                dfs(nextR, nextC, count + 1, sum + map[nextR][nextC]);
                visited[nextR][nextC] = false;
            }
        }
    }
}