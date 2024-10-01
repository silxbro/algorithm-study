package src.problem.baekjoon.level26_분할_정복;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class N1992_쿼드트리 {

    static int N;
    static int[][] video;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        video = new int[N][N];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                video[i][j] = line.charAt(j) - '0';
            }
        }

        System.out.println(quadTree(0, 0, N));
    }

    private static String quadTree(int row, int col, int len) {
        if (len == 1 || allSame(row, col, len)) {
            return String.valueOf(video[row][col]);
        }

        StringBuilder stb = new StringBuilder();
        stb.append("(")
            .append(quadTree(row, col, len / 2))
            .append(quadTree(row, col + len / 2, len / 2))
            .append(quadTree(row + len / 2, col, len / 2))
            .append(quadTree(row + len / 2, col + len / 2, len / 2))
            .append(")");
        return stb.toString();
    }

    private static boolean allSame(int row, int col, int len) {
        int first = video[row][col];
        for (int i = row; i < row + len; i++) {
            for (int j = col; j < col + len; j++) {
                if (video[i][j] != first) {
                    return false;
                }
            }
        }
        return true;
    }
}