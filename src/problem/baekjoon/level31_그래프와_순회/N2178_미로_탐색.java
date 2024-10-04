package src.problem.baekjoon.level31_그래프와_순회;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class N2178_미로_탐색 {

    static int N, M;
    static int[][] D;
    static boolean[][] visited;
    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        D = new int[N][M];
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                D[i][j] = line.charAt(j) - '0';
            }
        }

        dfs(0, 0);

        System.out.println(D[N - 1][M - 1]);
    }

    private static void dfs(int a, int b) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{a, b});
        visited[a][b] = true;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            for (int d = 0; d < 4; d++) {
                int nextR = now[0] + dr[d];
                int nextC = now[1] + dc[d];

                if (nextR >= 0 && nextR < N && nextC >= 0 && nextC < M && D[nextR][nextC] != 0 && !visited[nextR][nextC]) {
                    visited[nextR][nextC] = true;
                    D[nextR][nextC] = D[now[0]][now[1]] + 1;
                    queue.add(new int[]{nextR, nextC});
                }
            }
        }
    }
}