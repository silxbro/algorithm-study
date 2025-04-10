package src.problem.baekjoon.class03_gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class N20058_마법사_상어와_파이어스톰 {

    static int N, Q, n;
    static int[][] map;
    static boolean[][] visited;
    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, 1, -1};
    static int sum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());
        n = (int)Math.pow(2, N);
        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < Q; i++) {
            int q = Integer.parseInt(st.nextToken());
            map = melt(rotate(q));
        }

        int maxCount = 0;
        visited = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && map[i][j] > 0) {
                    maxCount = Math.max(maxCount, bfs(i, j));
                }
            }
        }

        System.out.println(sum);
        System.out.println(maxCount);
    }

    private static int[][] rotate(int q) {
        int range = (int)Math.pow(2, q);
        int[][] newMap = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int nextRow = (i / range) * range + (j % range);
                int nextCol = (j / range) * range + range - 1 - (i % range);
                newMap[nextRow][nextCol] = map[i][j];
            }
        }
        return newMap;
    }

    private static int[][] melt(int[][] map) {
        int[][] newMap = new int[n][n];
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                int count = 0;
                newMap[r][c] = map[r][c];
                for (int d = 0; d < 4; d++) {
                    int nextR = r + dr[d];
                    int nextC = c + dc[d];
                    if (nextR >= 0 && nextR < n && nextC >= 0 && nextC < n && map[nextR][nextC] > 0) {
                        count++;
                    }
                }
                if (count < 3) newMap[r][c]--;
            }
        }
        return newMap;
    }

    private static int bfs(int r, int c) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{r, c});
        visited[r][c] = true;
        sum += map[r][c];
        int count = 1;
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            for (int d = 0; d < 4; d++) {
                int nextR = now[0] + dr[d];
                int nextC = now[1] + dc[d];
                if (nextR >= 0 && nextR < n && nextC >= 0 && nextC < n && map[nextR][nextC] > 0 && !visited[nextR][nextC]) {
                    visited[nextR][nextC] = true;
                    queue.add(new int[]{nextR, nextC});
                    count++;
                    sum += map[nextR][nextC];
                }
            }
        }
        return count;
    }
}