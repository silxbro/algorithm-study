package src.problem.baekjoon.class03_gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

class N4179_불 {
    static int R, C;
    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};
    static char[][] map;
    static int[][] jt;
    static int[][] ft;
    static List<int[]> f;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        jt = new int[R][C]; // 지훈의 이동 시간
        ft = new int[R][C]; // 불의 이동 시간
        f = new ArrayList<>();  // 초기 불 위치
        int[] start = new int[2];

        for (int i = 0; i < R; i++) {
            String line = br.readLine();
            Arrays.fill(jt[i], -1);
            Arrays.fill(ft[i], -1);
            for (int j = 0; j < C; j++) {
                map[i][j] = line.charAt(j);
                if (map[i][j] == 'J') {
                    start[0] = i;
                    start[1] = j;
                    map[i][j] = '.';
                    jt[i][j] = 0;
                }
                if (map[i][j] == 'F') {
                    f.add(new int[]{i, j});
                    ft[i][j] = 0;
                }
            }
        }

        spreadFire();
        int result = bfs(start[0], start[1]);
        System.out.println(result == -1 ? "IMPOSSIBLE" : result);
    }

    private static void spreadFire() {
        Queue<int[]> queue = new LinkedList<>(f);
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            for (int d = 0; d < 4; d++) {
                int nextR = now[0] + dr[d];
                int nextC = now[1] + dc[d];
                if (nextR >= 0 && nextR < R && nextC >= 0 && nextC < C && ft[nextR][nextC] == -1 && map[nextR][nextC] == '.') {
                    ft[nextR][nextC] = ft[now[0]][now[1]] + 1;
                    queue.add(new int[]{nextR, nextC});
                }
            }
        }
    }

    private static int bfs(int r, int c) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{r, c});
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            // 가장자리일 경우 탈출 가능(시간 = 가장자리 도달 시간 + 1)
            if (now[0] == 0 || now[0] == R - 1 || now[1] == 0 || now[1] == C - 1) {
                return jt[now[0]][now[1]] + 1;
            }

            for (int d = 0; d < 4; d++) {
                int nextR = now[0] + dr[d];
                int nextC = now[1] + dc[d];
                if (nextR >= 0 && nextR < R && nextC >= 0 && nextC < C && map[nextR][nextC] == '.' && jt[nextR][nextC] == -1) {
                    // 불이 번지지 않았거나 지훈이가 불보다 먼저 도달 가능한 경우
                    if (ft[nextR][nextC] == -1 || jt[now[0]][now[1]] + 1 < ft[nextR][nextC]) {
                        jt[nextR][nextC] = jt[now[0]][now[1]] + 1;
                        queue.add(new int[]{nextR, nextC});
                    }
                }
            }
        }
        // 탈출 불가능한 경우
        return -1;
    }
}