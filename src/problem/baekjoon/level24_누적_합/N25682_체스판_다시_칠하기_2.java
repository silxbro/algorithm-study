package src.problem.baekjoon.level24_누적_합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class N25682_체스판_다시_칠하기_2 {

    static String[] chessLine;
    static int N, M, K;
    static int[][] W, B, DW, DB;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        chessLine = new String[N];
        W = new int[N + 1][M + 1];  // 짝수가 흰색, 홀수가 검은색
        B = new int[N + 1][M + 1];  // 짝수가 검은색, 홀수가 흰색
        DW = new int[N + 1][M + 1];
        DB = new int[N + 1][M + 1];
        for (int i = 0; i < N; i++) {
            chessLine[i] = br.readLine();
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                char color = chessLine[i].charAt(j);
                W[i + 1][j + 1] = ((i + j) % 2 == 0 && color == 'B') || ((i + j) % 2 != 0 && color == 'W') ? 1 : 0;
                B[i + 1][j + 1] = ((i + j) % 2 == 0 && color == 'W') || ((i + j) % 2 != 0 && color == 'B') ? 1 : 0;
            }
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                DW[i][j] = DW[i - 1][j] + DW[i][j - 1] - DW[i - 1][j - 1] + W[i][j];
                DB[i][j] = DB[i - 1][j] + DB[i][j - 1] - DB[i - 1][j - 1] + B[i][j];
            }
        }

        int min = Integer.MAX_VALUE;

        for (int i = K; i <= N; i++) {
            for (int j = K; j <= M; j++) {
                int wCount = DW[i][j] - DW[i - K][j] - DW[i][j - K] + DW[i - K][j - K];
                int bCount = DB[i][j] - DB[i - K][j] - DB[i][j - K] + DB[i - K][j - K];
                min = Math.min(min, Math.min(wCount, bCount));
            }
        }

        System.out.println(min);
    }
}