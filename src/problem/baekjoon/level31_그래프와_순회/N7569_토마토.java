package src.problem.baekjoon.level31_그래프와_순회;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class N7569_토마토 {

    static int M, N, H;
    static Queue<int[]> queue;
    static int[][][] tomatoes;
    static int maxDays = 1;
    static int remaining;
    static int[] dr = {0, 0, 0, 0, 1, -1};
    static int[] dc = {1, -1, 0, 0, 0, 0};
    static int[] dh = {0, 0, 1, -1, 0, 0};


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        tomatoes = new int[N][M][H];
        queue = new LinkedList<>();
        for (int h = 0; h < H; h++) {
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < M; j++) {
                    tomatoes[i][j][h] = Integer.parseInt(st.nextToken());
                    if (tomatoes[i][j][h] == 1) {
                        queue.add(new int[]{i, j, h});
                    }
                    if (tomatoes[i][j][h] == 0) {
                        remaining++;
                    }
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] now = queue.poll();

            for (int d = 0; d < 6; d++) {
                int nextR = now[0] + dr[d];
                int nextC = now[1] + dc[d];
                int nextH = now[2] + dh[d];

                if (nextR >= 0 && nextR < N && nextC >= 0 && nextC < M && nextH >= 0 && nextH < H && tomatoes[nextR][nextC][nextH] == 0) {
                    tomatoes[nextR][nextC][nextH] = tomatoes[now[0]][now[1]][now[2]] + 1;
                    maxDays = Math.max(maxDays, tomatoes[nextR][nextC][nextH]);
                    remaining--;
                    queue.add(new int[]{nextR, nextC, nextH});
                }
            }
        }

        if (remaining > 0) {
            maxDays = 0;
        }

        System.out.println(maxDays - 1);
    }
}