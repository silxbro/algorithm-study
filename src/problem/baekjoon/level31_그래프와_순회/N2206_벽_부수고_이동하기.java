package src.problem.baekjoon.level31_그래프와_순회;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class N2206_벽_부수고_이동하기 {

    static int[][] map;
    static int[][] temp;
    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        temp = new int[N][M];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }

        bfs();
        System.out.println(map[N - 1][M - 1] - 1);
    }

    private static void bfs() {
        Queue<Node> queue = new LinkedList<>();
        map[0][0] = 2;
        queue.add(new Node(0, 0, map[0][0], false));
        while (!queue.isEmpty()) {
            Node now = queue.poll();
            if (now.row == N - 1 && now.col == M - 1) {
                map[now.row][now.col] = now.dist;
                break;
            }
            for (int d = 0; d < 4; d++) {
                int nextR = now.row + dr[d];
                int nextC = now.col + dc[d];
                if (nextR >= 0 && nextR < N && nextC >= 0 && nextC < M) {
                    if (now.broken && map[nextR][nextC] == 0 && temp[nextR][nextC] == 0) {
                        temp[nextR][nextC] = now.dist + 1;
                        queue.add(new Node(nextR, nextC, temp[nextR][nextC], true));
                    }
                    if (!now.broken && map[nextR][nextC] == 0) {
                        map[nextR][nextC] = map[now.row][now.col] + 1;
                        queue.add(new Node(nextR, nextC, map[nextR][nextC], false));
                    }
                    if (!now.broken && map[nextR][nextC] == 1) {
                        temp[nextR][nextC] = map[now.row][now.col] + 1;
                        queue.add(new Node(nextR, nextC, temp[nextR][nextC], true));
                    }
                }
            }
        }
    }
}

class Node {
    int row;
    int col;
    int dist;
    boolean broken;

    Node (int row, int col, int dist, boolean broken) {
        this.row = row;
        this.col = col;
        this.dist = dist;
        this.broken = broken;
    }
}