package src.problem.baekjoon.level26_분할_정복;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class N10830_행렬_제곱 {

    static long[][] A;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        long B = Long.parseLong(st.nextToken());

        A = new long[N][N];

        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < N; c++) {
                A[r][c] = Integer.parseInt(st.nextToken()) % 1000;
            }
        }

        long[][] answer = dc(A, B);
        StringBuilder stb = new StringBuilder();
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                stb.append(answer[r][c]).append(" ");
            }
            stb.append("\n");
        }
        System.out.println(stb);
    }

    private static long[][] dc(long[][] A, long B) {
        if (B == 1) {
            return A;
        }
        long[][] temp = dc(A, B / 2);
        long[][] result = mul(temp, temp);
        if (B % 2 != 0) {
            return mul(result, A);
        }
        return result;
    }

    private static long[][] mul(long[][] a, long[][] b) {
        long[][] result = new long[N][N];
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                for (int n = 0; n < N; n++) {
                    result[r][c] = (result[r][c] + a[r][n] * b[n][c]) % 1000;
                }
            }
        }
        return result;
    }
}