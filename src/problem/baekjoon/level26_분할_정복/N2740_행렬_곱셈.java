package src.problem.baekjoon.level26_분할_정복;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class N2740_행렬_곱셈 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int R1 = Integer.parseInt(st.nextToken());
        int C1 = Integer.parseInt(st.nextToken());
        int[][] P1 = new int[R1][C1];
        for (int r = 0; r < R1; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < C1; c++) {
                P1[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        int R2 = Integer.parseInt(st.nextToken());
        int C2 = Integer.parseInt(st.nextToken());
        int[][] P2 = new int[R2][C2];
        for (int r = 0; r < R2; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < C2; c++) {
                P2[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] answer = new int[R1][C2];
        for (int r = 0; r < R1; r++) {
            for (int c = 0; c < C2; c++) {
                int repeat = R2;
                for (int n = 0; n < repeat; n++) {
                    answer[r][c] += P1[r][n] * P2[n][c];
                }
            }
        }

        StringBuilder stb = new StringBuilder();
        for (int r = 0; r < answer.length; r++) {
            for (int c = 0; c < answer[r].length; c++) {
                stb.append(answer[r][c]).append(" ");
            }
            stb.append("\n");
        }
        System.out.println(stb);
    }
}