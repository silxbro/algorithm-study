package src.problem.baekjoon.class03_gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class N14499_주사위_굴리기 {

    static int N, M, x, y, K;
    static int[][] map;
    static int[] dice;
    static int[] now;
    static int[] dr = {0, 0, -1, 1};
    static int[] dc = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        dice = new int[6];
        now = new int[]{x, y};

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        StringBuilder stb = new StringBuilder();
        for (int i = 0; i < K; i++) {
            int dir = Integer.parseInt(st.nextToken());
            if (move(dir)) {
                stb.append(dice[0]).append("\n");
            }
        }

        System.out.println(stb);
    }

    private static boolean move(int dir) {
        int nextR = now[0] + dr[dir - 1];
        int nextC = now[1] + dc[dir - 1];
        if (nextR >= 0 && nextR < N && nextC >= 0 && nextC < M) {
            //주사위 위치 업데이트
            now[0] = nextR;
            now[1] = nextC;
            //주사위 각 면의 숫자 업데이트
            int[] newDice = new int[6];
            newDice[0] = dir == 1 ? dice[3] : dir == 2 ? dice[2] : dir == 3 ? dice[4] : dice[1];
            newDice[1] = dir == 3 ? dice[0] : dir == 4 ? dice[5] : dice[1];
            newDice[2] = dir == 1 ? dice[0] : dir == 2 ? dice[5] : dice[2];
            newDice[3] = dir == 1 ? dice[5] : dir == 2 ? dice[0] : dice[3];
            newDice[4] = dir == 3 ? dice[5] : dir == 4 ? dice[0] : dice[4];
            newDice[5] = dir == 1 ? dice[2] : dir == 2 ? dice[3] : dir == 3 ? dice[1] : dice[4];
            dice = newDice;
            //주사위 바닥면 또는 지도 숫자 복사
            if (map[nextR][nextC] == 0) {
                map[nextR][nextC] = dice[5];
            } else {
                dice[5] = map[nextR][nextC];
                map[nextR][nextC] = 0;
            }
            return true;
        }
        return false;
    }
}