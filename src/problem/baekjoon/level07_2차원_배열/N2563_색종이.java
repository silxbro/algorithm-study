package src.problem.baekjoon.level07_2차원_배열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class N2563_색종이 {

    public static void main(String[] args) throws IOException {
        boolean[][] paper = new boolean[101][101];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int answer = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int startCol = Integer.parseInt(st.nextToken());
            int startRow = Integer.parseInt(st.nextToken());
            for (int r = startRow; r < startRow + 10; r++) {
                for (int c = startCol; c < startCol + 10; c++) {
                    if (!paper[r][c]) {
                        paper[r][c] = true;
                        answer++;
                    }
                }
            }
        }
        System.out.println(answer);
    }
}