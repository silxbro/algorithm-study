package src.problem.baekjoon.level31_그래프와_순회;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

class N2667_단지번호붙이기 {

    static int N;
    static int[][] house;
    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        house = new int[N][N];
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                house[i][j] = line.charAt(j) - '0';
            }
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (house[i][j] != 0) {
                    pq.add(bfs(i, j));
                }
            }
        }

        StringBuilder stb = new StringBuilder();
        stb.append(pq.size()).append("\n");
        while (!pq.isEmpty()) {
            stb.append(pq.poll()).append("\n");
        }
        System.out.println(stb);
    }

    private static int bfs(int r, int c) {
        int count = 1;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{r, c});
        house[r][c] = 0;
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            for (int d = 0; d < 4; d++) {
                int nextR = now[0] + dr[d];
                int nextC = now[1] + dc[d];
                if (nextR >= 0 && nextR < N && nextC >= 0 && nextC < N && house[nextR][nextC] != 0) {
                    queue.add(new int[]{nextR, nextC});
                    house[nextR][nextC] = 0;
                    count++;
                }
            }
        }
        return count;
    }
}