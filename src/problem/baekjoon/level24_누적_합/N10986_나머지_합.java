package src.problem.baekjoon.level24_누적_합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class N10986_나머지_합 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        long[] S = new long[N + 1];
        int[] remain = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            S[i] = S[i - 1] + Long.parseLong(st.nextToken());
            remain[(int)(S[i] % M)]++;
        }

        long count = remain[0];
        for (int i = 0; i < remain.length; i++) {
            // 각 나머지에 해당하는 수의 쌍의 개수
            count += (long) remain[i] * (remain[i] - 1) / 2;
        }
        System.out.println(count);
    }
}