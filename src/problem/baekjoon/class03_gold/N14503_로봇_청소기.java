package src.problem.baekjoon.class03_gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class N14503_로봇_청소기 {

    static int N, M;
    static int[][] map;
    static int[] now = new int[2];
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        now[0] = Integer.parseInt(st.nextToken());
        now[1] = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int count = 0;
        while (true) {
            if (map[now[0]][now[1]] == 0) {
                map[now[0]][now[1]] = -1;
                count++;
            }
            boolean exist = false;
            for (int i = 0; i < 4; i++) {
                d--;
                if (d == -1) {
                    d = 3;
                }
                int nextR = now[0] + dr[d];
                int nextC = now[1] + dc[d];
                if (nextR >= 0 && nextR < N && nextC >= 0 && nextC < M && map[nextR][nextC] == 0) {
                    now[0] = nextR;
                    now[1] = nextC;
                    exist = true;
                    break;
                }
            }
            if (!exist) {
                int nextR = now[0] - dr[d];
                int nextC = now[1] - dc[d];
                if (nextR >= 0 && nextR < N && nextC >= 0 && nextC < M && map[nextR][nextC] != 1) {
                    now[0] = nextR;
                    now[1] = nextC;
                } else {
                    break;
                }
            }
        }
        System.out.println(count);
    }
}