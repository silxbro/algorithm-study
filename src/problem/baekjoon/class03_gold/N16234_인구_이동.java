package src.problem.baekjoon.class03_gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

class N16234_인구_이동 {

    static int N, L, R;
    static int[][] map;
    static boolean[][] visited;
    static int count;
    static boolean move;
    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while (true) {
            visited = new boolean[N][N];
            move = false;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visited[i][j]) {
                        bfs(i, j);
                    }
                }
            }
            if (!move) {
                break;
            }
            count++;
        }

        System.out.println(count);
    }

    private static void bfs(int i, int j) {
        List<int[]> nations = new ArrayList<>();
        int sum = map[i][j];
        Queue<int[]> queue = new LinkedList<>();
        visited[i][j] = true;
        nations.add(new int[]{i, j});
        queue.add(new int[]{i, j});
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            for (int d = 0; d < 4; d++) {
                int nextR = now[0] + dr[d];
                int nextC = now[1] + dc[d];

                if (nextR >= 0 && nextR < N && nextC >= 0 && nextC < N && !visited[nextR][nextC]) {
                    int diff = Math.abs(map[now[0]][now[1]] - map[nextR][nextC]);
                    if (diff >= L && diff <= R) {
                        visited[nextR][nextC] = true;
                        sum += map[nextR][nextC];
                        nations.add(new int[]{nextR, nextC});
                        queue.add(new int[]{nextR, nextC});
                    }
                }
            }
        }
        if (nations.size() > 1) {
            move = true;
        }
        int divide = sum / nations.size();
        for (int[] nation : nations) {
            map[nation[0]][nation[1]] = divide;
        }
    }
}