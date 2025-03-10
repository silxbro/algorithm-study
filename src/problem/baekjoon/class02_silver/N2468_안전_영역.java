package src.problem.baekjoon.class02_silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class N2468_안전_영역 {

    static int answer = 1;
    static int N;
    static int[][] map;
    static boolean[][] visited;
    static int[] dr = {1, 0, -1, 0};
    static int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        int maxValue = 0;
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                maxValue = Math.max(maxValue, map[i][j]);
            }
        }

        for (int h = 1; h <= maxValue; h++) {
            visited = new boolean[N][N];
            int count = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visited[i][j] && map[i][j] > h) {
                        count++;
                        bfs(i, j, h);
                    }
                }
            }
            answer = Math.max(answer, count);
        }

        System.out.println(answer);
    }

    private static void bfs(int r, int c, int h) {
        Queue<int[]> queue = new LinkedList<>();
        visited[r][c] = true;
        queue.add(new int[]{r, c});
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            for (int d = 0; d < 4; d++) {
                int nextR = now[0] + dr[d];
                int nextC = now[1] + dc[d];
                if (nextR >= 0 && nextR < N && nextC >= 0 && nextC < N && !visited[nextR][nextC] && map[nextR][nextC] > h) {
                    visited[nextR][nextC] = true;
                    queue.add(new int[]{nextR, nextC});
                }
            }
        }
    }
}