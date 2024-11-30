package src.problem.baekjoon.class03_gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

class N2636_치즈 {

    static int N, M;
    static int[][] map;
    static int[][] time;
    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        time = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                time[i][j] = -1;
            }
        }

        simulation();
        int max = 0;
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 1) {
                    if (time[i][j] > max) {
                        max = time[i][j];
                        count = 0;
                    }
                    if (time[i][j] == max) {
                        count++;
                    }
                }

            }
        }
        System.out.println(max);
        System.out.println(count);
    }

    private static void simulation() {
        time[0][0] = 0;
        Queue<int[]> queue = new LinkedList<>(getAirs(0, 0));
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            for (int d = 0; d < 4; d++) {
                int nextR = now[0] + dr[d];
                int nextC = now[1] + dc[d];
                if (nextR >= 0 && nextR < N && nextC >= 0 && nextC < M && map[nextR][nextC] == 1 && time[nextR][nextC] == -1) {
                    time[nextR][nextC] = time[now[0]][now[1]] + 1;
                    queue.addAll(getAirs(nextR, nextC));
                }
            }
        }
    }

    private static List<int[]> getAirs(int r, int c) {
        List<int[]> list = new ArrayList<>();
        Queue<int[]> queue = new LinkedList<>();

        queue.add(new int[]{r, c});
        list.add(new int[]{r, c});
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            for (int d = 0; d < 4; d++) {
                int nextR = now[0] + dr[d];
                int nextC = now[1] + dc[d];
                if (nextR >= 0 && nextR < N && nextC >= 0 && nextC < M && map[nextR][nextC] == 0 && time[nextR][nextC] == -1) {
                    time[nextR][nextC] = time[r][c];
                    list.add(new int[]{nextR, nextC});
                    queue.add(new int[]{nextR, nextC});
                }
            }
        }
        return list;

    }
}