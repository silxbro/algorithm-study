package src.problem.baekjoon.class03_gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class N2573_빙산 {

    static int N, M;
    static int iceCount;
    static int[][] map;
    static int[] dr = {0, 0, 1, -1};
    static int[] dc = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] > 0) {
                    iceCount++;
                }
            }
        }

        int answer = 0;
        int time = 1;
        while (true) {
            map = meltIce();
            if (iceCount == 0) {
                break;
            }
            if (iceCount > countFirstIce()) {
                answer = time;
                break;
            }
            time++;
        }
        System.out.println(answer);
    }

    private static int[][] meltIce() {
        int[][] newMap = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) {
                    continue;
                }
                newMap[i][j] = map[i][j];
                for (int d = 0; d < 4; d++) {
                    int nextR = i + dr[d];
                    int nextC = j + dc[d];
                    if (nextR >= 0 && nextR < N && nextC >= 0 && nextC < M && map[nextR][nextC] == 0 && newMap[i][j] > 0) {
                        newMap[i][j]--;
                    }
                }
                if (newMap[i][j] == 0) {
                    iceCount--;
                }
            }
        }
        return newMap;
    }

    private static int countFirstIce() {
        int count = 0;
        boolean[][] visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) {
                    continue;
                }
                visited[i][j] = true;
                Queue<int[]> queue = new ArrayDeque<>();
                queue.add(new int[]{i, j});
                count++;
                while (!queue.isEmpty()) {
                    int[] now = queue.poll();
                    for (int d = 0; d < 4; d++) {
                        int nextR = now[0] + dr[d];
                        int nextC = now[1] + dc[d];
                        if (nextR >= 0 && nextR < N && nextC >= 0 && nextC < M && map[nextR][nextC] > 0 && !visited[nextR][nextC]) {
                            visited[nextR][nextC] = true;
                            count++;
                            queue.add(new int[]{nextR, nextC});
                        }
                    }
                }
                return count;
            }
        }
        return 0;
    }
}