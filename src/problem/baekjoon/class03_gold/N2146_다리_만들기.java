package src.problem.baekjoon.class03_gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class N2146_다리_만들기 {
    static int N;
    static int[][] map;
    static int[][] temp;
    static int minDist;
    static int[] dr = {0, 0, 1, -1};
    static int[] dc = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int num = Integer.parseInt(st.nextToken());
                map[i][j] = num == 1 ? -1 : 0;
            }
        }

        int num = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == -1) {
                    num++;
                    map[i][j] = num;
                    bfs(i, j);
                }
            }
        }

        minDist = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] != 0) {
                    temp = new int[N][N];
                    simulate(i, j);
                }
            }
        }

        System.out.println(minDist);
    }

    private static void bfs(int r, int c) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{r, c});
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            for (int d = 0; d < 4; d++) {
                int nextR = now[0] + dr[d];
                int nextC = now[1] + dc[d];
                if (nextR >= 0 && nextR < N && nextC >= 0 && nextC < N && map[nextR][nextC] == -1) {
                    map[nextR][nextC] = map[now[0]][now[1]];
                    queue.add(new int[]{nextR, nextC});
                }
            }
        }
    }

    private static void simulate(int r, int c) {
        int num = map[r][c];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{r, c});
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            for (int d = 0; d < 4; d++) {
                int nextR = now[0] + dr[d];
                int nextC = now[1] + dc[d];
                if (nextR >= 0 && nextR < N && nextC >= 0 && nextC < N && temp[nextR][nextC] == 0) {
                    if (map[nextR][nextC] == 0) {
                        temp[nextR][nextC] = temp[now[0]][now[1]] + 1;
                        queue.add(new int[]{nextR, nextC});
                    }
                    if (map[nextR][nextC] > num) {
                        minDist = Math.min(minDist, temp[now[0]][now[1]]);
                    }
                }
            }
        }
    }
}