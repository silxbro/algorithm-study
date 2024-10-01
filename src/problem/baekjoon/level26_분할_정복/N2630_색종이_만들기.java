package src.problem.baekjoon.level26_분할_정복;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class N2630_색종이_만들기 {
    static int N;
    static int[][] color;
    static int white, blue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        color = new int[N][N];
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                color[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        white = 0;
        blue = 0;
        dc(0, 0, N);
        StringBuilder stb = new StringBuilder();
        System.out.println(stb.append(white).append("\n").append(blue));
    }

    private static void dc(int r, int c, int len) {
        if (len == 1 || allSame(r, c, len)) {
            check(color[r][c]);
            return;
        }
        dc(r, c, len / 2);
        dc(r + len / 2, c, len / 2);
        dc(r, c + len / 2, len / 2);
        dc(r + len / 2, c + len / 2, len / 2);
    }

    private static boolean allSame(int r, int c, int len) {
        int standard = color[r][c];
        for (int i = r; i < r + len; i++) {
            for (int j = c; j < c + len; j++) {
                if (color[i][j] != standard) {
                    return false;
                }
            }
        }
        return true;
    }

    private static void check(int color) {
        if (color == 0) {
            white++;
        } else {
            blue++;
        }
    }
}