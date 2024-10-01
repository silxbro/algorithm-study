package src.problem.baekjoon.level26_분할_정복;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class N1780_종이의_개수 {

    static int N;
    static int[][] paper;
    static int[] answer = new int[3];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        paper = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dc(0, 0, N);
        StringBuilder stb = new StringBuilder();
        stb.append(answer[0]).append("\n")
            .append(answer[1]).append("\n")
            .append(answer[2]);
        System.out.println(stb);
    }

    private static void dc(int row, int col, int len) {
        if (len == 1 || allSame(row, col, len)) {
            answer[paper[row][col] + 1]++;
            return;
        }

        for (int i = row; i < row + len; i += len / 3) {
            for (int j = col; j < col + len; j += len / 3) {
                dc(i, j, len / 3);
            }
        }
    }

    private static boolean allSame(int row, int col, int len) {
        int start = paper[row][col];
        for (int i = row; i < row + len; i++) {
            for (int j = col; j < col + len; j++) {
                if (paper[i][j] != start) {
                    return false;
                }
            }
        }
        return true;
    }
}