package src.problem.baekjoon.level31_그래프와_순회;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class N7576_토마토 {
    static Queue<int[]> queue;
    static int M, N;
    static int[][] tomatoes;
    static int maxDays;
    static int remaining;
    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        tomatoes = new int[N][M];
        queue = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                tomatoes[i][j] = Integer.parseInt(st.nextToken());
                if (tomatoes[i][j] == 1) {
                    queue.add(new int[]{i, j});
                }
                if (tomatoes[i][j] == 0) {
                    remaining++;
                }
            }
        }

        maxDays = 1;
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            for (int d = 0; d < 4; d++) {
                int nextR = now[0] + dr[d];
                int nextC = now[1] + dc[d];
                if (nextR >= 0 && nextR < N && nextC >= 0 && nextC < M && tomatoes[nextR][nextC] == 0) {
                    tomatoes[nextR][nextC] = tomatoes[now[0]][now[1]] + 1;
                    maxDays = Math.max(maxDays, tomatoes[nextR][nextC]);
                    queue.add(new int[]{nextR, nextC});
                    remaining--;
                }
            }
        }

        if (remaining > 0) {
            maxDays = 0;
        }

        System.out.println(maxDays - 1);
    }
}