package src.problem.baekjoon.class03_gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class N21610_마법사_상어와_비바라기 {

    static int N, M;
    static int[][] map;
    static boolean[][] visited;
    static Queue<int[]> clouds;
    static int[] dr = {0, -1, -1, -1, 0, 1, 1, 1};
    static int[] dc = {-1, -1, 0, 1, 1, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        clouds = new LinkedList<>();
        clouds.add(new int[]{N - 1, 0});
        clouds.add(new int[]{N - 1, 1});
        clouds.add(new int[]{N - 2, 0});
        clouds.add(new int[]{N - 2, 1});

        for (int i = 0; i < M; i++) {
            visited = new boolean[N][N];
            st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken()) - 1;
            int s = Integer.parseInt(st.nextToken());
            int dR = dr[d] < 0 ? N + dr[d] : dr[d];
            int dC = dc[d] < 0 ? N + dc[d] : dc[d];

            while (!clouds.isEmpty()) {
                int[] cloud = clouds.poll();
                int nextR = (cloud[0] + dR * s) % N;
                int nextC = (cloud[1] + dC * s) % N;
                map[nextR][nextC]++;
                visited[nextR][nextC] = true;
            }

            int[][] newMap = new int[N][N];
            for (int r = 0; r < N; r++) {
                for (int c = 0; c < N; c++) {
                    newMap[r][c] = map[r][c];
                    if (!visited[r][c] && map[r][c] >= 2) {
                        clouds.add(new int[]{r, c});
                        newMap[r][c] -= 2;
                    }
                    if (visited[r][c]) {
                        for (int dir = 0; dir < 8; dir++) {
                            if (dr[dir] != 0 && dc[dir] != 0) {
                                int nextR = r + dr[dir];
                                int nextC = c + dc[dir];
                                if (nextR >= 0 && nextR < N && nextC >= 0 && nextC < N && map[nextR][nextC] > 0) {
                                    newMap[r][c]++;
                                }
                            }
                        }
                    }
                }
            }

            map = newMap;
        }

        int sum = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sum += map[i][j];
            }
        }
        System.out.println(sum);
    }
}