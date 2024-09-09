package src.problem.baekjoon.level12_브루트_포스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class N1018_체스판_다시_칠하기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int count = Integer.MAX_VALUE;

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        String[] board = new String[N];
        for (int i = 0; i < N; i++) {
            board[i] = br.readLine();
        }
        for (int n = 0; n <= N - 8; n++) {
            for (int m = 0; m <= M - 8; m++) {
                int count1 = 0; // 검은색부터 시작 (짝수가 검은색)
                int count2 = 0; // 흰색부터 시작  (짝수가 흰색)
                for (int i = n; i < n + 8; i++) {
                    for (int j = m; j < m + 8; j++) {
                        char color = board[i].charAt(j);
                        if ((i + j) % 2 == 0 && color != 'B' || (i + j) % 2 != 0 && color != 'W') {
                            count1++;
                            continue;
                        }
                        if ((i + j) % 2 == 0 && color != 'W' || (i + j) % 2 != 0 && color != 'B') {
                            count2++;
                        }
                    }
                }
                count = Math.min(count, Math.min(count1, count2));
            }
        }
        System.out.println(count);
    }
}