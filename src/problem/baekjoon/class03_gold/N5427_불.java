package src.problem.baekjoon.class03_gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class N5427_불 {

    static int h, w;
    static int[][] map;
    static int[][] fire;
    static int[] start;
    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};
    static Queue<int[]> queue;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder stb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            map = new int[h][w];
            fire = new int[h][w];
            start = new int[2];
            queue = new LinkedList<>();

            for (int i = 0; i < h; i++) {
                String line = br.readLine();
                for (int j = 0; j < w; j++) {
                    char c = line.charAt(j);
                    if (c == '*') {
                        fire[i][j] = 1;
                        queue.add(new int[]{i, j});
                    }
                    if (c == '#') {
                        map[i][j] = -1;
                        fire[i][j] = -1;
                    }
                    if (c == '@') {
                        map[i][j] = 1;
                        start[0] = i;
                        start[1] = j;
                    }
                }
            }

            spreadFire();
            int answer = run();

            stb.append(answer == 0 ? "IMPOSSIBLE" : answer).append("\n");
        }
        System.out.println(stb);
    }

    private static void spreadFire() {
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            for (int d = 0; d < 4; d++) {
                int nextR = now[0] + dr[d];
                int nextC = now[1] + dc[d];
                if (nextR >= 0 && nextR < h && nextC >= 0 && nextC < w && fire[nextR][nextC] == 0) {
                    fire[nextR][nextC] = fire[now[0]][now[1]] + 1;
                    queue.add(new int[]{nextR, nextC});
                }
            }
        }
    }

    private static int run() {
        queue = new LinkedList<>();
        queue.add(new int[]{start[0], start[1]});
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            for (int d = 0; d < 4; d++) {
                int nextR = now[0] + dr[d];
                int nextC = now[1] + dc[d];
                if (nextR < 0 || nextR >= h || nextC < 0 || nextC >= w) {
                    return map[now[0]][now[1]];
                }
                if (map[nextR][nextC] == 0) {
                    if (fire[nextR][nextC] == 0 || fire[nextR][nextC] > map[now[0]][now[1]] + 1) {
                        map[nextR][nextC] = map[now[0]][now[1]] + 1;
                        queue.add(new int[]{nextR, nextC});
                    }
                }
            }
        }
        return 0;
    }
}