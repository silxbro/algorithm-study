package src.problem.baekjoon.class03_gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N18808_스티커_붙이기 {

    static int N, M, K;
    static int[][] map;
    static int[][] part;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        int count = 0;
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int R = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            part = new int[R][C];
            for (int r = 0; r < R; r++) {
                st = new StringTokenizer(br.readLine());
                for (int c = 0; c < C; c++) {
                    part[r][c] = Integer.parseInt(st.nextToken());
                }
            }

            int[] pos = getPos();
            if (pos[0] == -1 && pos[1] == -1) continue;

            for (int r = 0; r < part.length; r++) {
                for (int c = 0; c < part[0].length; c++) {
                    if (part[r][c] == 1 && map[pos[0] + r][pos[1] + c] == 0) {
                        count++;
                        map[pos[0] + r][pos[1] + c] = part[r][c];
                    }
                }
            }
        }

        System.out.println(count);
    }

    private static int[] getPos() {
        for (int i = 0; i < 4; i++) {
            for (int r = 0; r < N; r++) {
                for (int c = 0; c < M; c++) {
                    if (canStick(r, c, part)) {
                        return new int[]{r, c};
                    }
                }
            }
            part = rotate();
        }

        return new int[]{-1, -1};
    }

    private static int[][] rotate() {
        int row = part[0].length;
        int col = part.length;
        int[][] rotated = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                rotated[i][col - 1 - j] = part[j][i];
            }
        }
        return rotated;
    }

    private static boolean canStick(int r, int c, int[][] part) {
        for (int i = 0; i < part.length; i++) {
            for (int j = 0; j < part[i].length; j++) {
                int nextR = r + i;
                int nextC = c + j;
                if (nextR < 0 || nextR >= N || nextC < 0 || nextC >= M) {
                    return false;
                }
                if (part[i][j] != 0 && map[nextR][nextC] != 0) {
                    return false;
                }
            }
        }
        return true;
    }
}