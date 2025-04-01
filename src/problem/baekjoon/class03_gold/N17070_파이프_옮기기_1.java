package src.problem.baekjoon.class03_gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N17070_파이프_옮기기_1 {
    static int N;
    static int[][] map;
    static int[] dr = {0, 1, 1};
    static int[] dc = {1, 1, 0};
    static int count;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        backtrack(0, 1, 0);

        System.out.println(count);
    }

    private static void backtrack(int r2, int c2, int dir) {
        if (r2 == N - 1 && c2 == N - 1) {
            count++;
            return;
        }
        for (int d = 0; d < 3; d++) {
            int diff = Math.abs(dir - d);
            int nextR = r2 + dr[d];
            int nextC = c2 + dc[d];
            if (diff <= 1 && nextR >= 0 && nextR < N && nextC >= 0 && nextC < N && map[nextR][nextC] == 0) {
                if (d == 1 && (map[nextR - 1][nextC] == 1 || map[nextR][nextC - 1] == 1)) {
                    continue;
                }
                backtrack(nextR, nextC, d);
            }
        }
    }
}