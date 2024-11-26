package src.problem.baekjoon.class03_gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class N15685_드래곤_커브 {
    static boolean[][] visited;
    static int[] dr = {0, -1, 0, 1};
    static int[] dc = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        visited = new boolean[101][101];
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());
            dragonCurve(x, y, d, g);
        }
        int count = 0;
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if (visited[i][j] && visited[i + 1][j] && visited[i][j + 1] && visited[i + 1][j + 1]) {
                    count++;
                }
            }
        }

        System.out.println(count);
    }

    private static void dragonCurve(int x, int y, int d, int g) {
        int[] dir = new int[(int)Math.pow(2, g)];
        dir[0] = d;
        for (int i = 1; i <= g; i++) {
            for (int j = (int)Math.pow(2, i - 1); j < (int)Math.pow(2, i); j++) {
                int num = (int)Math.pow(2, i) - 1;
                dir[j] = (dir[num - j] + 5) % 4;
            }
        }
        visited[y][x] = true;
        int r = y;
        int c = x;
        for (int i = 0; i < dir.length; i++) {
            r = r + dr[dir[i]];
            c = c + dc[dir[i]];
            visited[r][c] = true;
        }
    }
}