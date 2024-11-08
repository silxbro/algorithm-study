package src.problem.baekjoon.class03_gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class N4485_녹색_옷_입은_애가_젤다지 {

    static int[][] map;
    static int[][] loss;
    static int N;
    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder stb = new StringBuilder();
        int prob = 0;

        while (true) {
            N = Integer.parseInt(br.readLine());
            if (N == 0) {
                break;
            }
            prob++;
            map = new int[N][N];
            loss = new int[N][N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                Arrays.fill(loss[i], Integer.MAX_VALUE);
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            bfs();

            stb.append(String.format("Problem %d: %d", prob, loss[N - 1][N - 1])).append("\n");
        }
        System.out.println(stb);
    }

    private static void bfs() {
        loss[0][0] = map[0][0];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            for (int d = 0; d < 4; d++) {
                int nextR = now[0] + dr[d];
                int nextC = now[1] + dc[d];
                if (nextR >= 0 && nextR < N && nextC >= 0 && nextC < N) {
                    if (loss[nextR][nextC] > loss[now[0]][now[1]] + map[nextR][nextC]) {
                        loss[nextR][nextC] = loss[now[0]][now[1]] + map[nextR][nextC];
                        queue.add(new int[]{nextR, nextC});
                    }
                }
            }
        }
    }
}