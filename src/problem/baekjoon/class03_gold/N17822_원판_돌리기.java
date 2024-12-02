package src.problem.baekjoon.class03_gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class N17822_원판_돌리기 {

    static int N, M, T;
    static int[][] map;
    static double sum;
    static int[] dr = {0, 0, 1, -1};
    static int[] dc = {1, -1, 0, 0};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        map = new int[N + 1][M];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                sum += map[i][j];
            }
        }

        int totalCount = N * M;
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            for (int j = 1; j <= N; j++) {
                if (j % x == 0) {
                    rotate(j, d, k);
                }
            }
            int removedCount = remove();
            totalCount -= removedCount;
            if (removedCount == 0) {
                averageWork(sum / totalCount);
            }
        }
        System.out.println((int)sum);
    }

    private static void rotate(int num, int dir, int count) {
        int[] newCircle = new int[M];
        dir = dir == 0 ? 1 : -1;
        for (int i = 0; i < M; i++) {
            int nextM = ((i + dir * count) + M) % M;
            newCircle[nextM] = map[num][i];
        }
        map[num] = newCircle;
    }

    private static int remove() {
        int count = 0;
        for (int i = 1; i <= N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] != 0) {
                    int removedCount = bfs(i, j);
                    if (removedCount > 1) {
                        count += removedCount;
                    }
                }
            }
        }
        return count;
    }

    private static int bfs(int r, int c) {
        int count = 1;
        int num = map[r][c];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{r, c});
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            for (int d = 0; d < 4; d++) {
                int nextR = now[0] + dr[d];
                int nextC = (now[1] + dc[d] + M) % M;
                if (nextR >= 1 && nextR <= N && map[nextR][nextC] == num) {
                    count++;
                    map[nextR][nextC] = 0;
                    if (map[r][c] != 0) {
                        map[r][c] = 0;
                    }
                    queue.add(new int[]{nextR, nextC});
                }
            }
        }
        if (count > 1) {
            sum -= count * num;
        }
        return count;
    }

    private static void averageWork(double average) {
        for (int i = 1; i <= N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] > average) {
                    map[i][j]--;
                    sum--;
                } else if (map[i][j] < average && map[i][j] > 0) {
                    map[i][j]++;
                    sum++;
                }
            }
        }
    }
}