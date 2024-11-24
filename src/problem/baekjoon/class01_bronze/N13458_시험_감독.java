package src.problem.baekjoon.class01_bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class N13458_시험_감독 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        long[] A = new long[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Long.parseLong(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        long B = Long.parseLong(st.nextToken());
        long C = Long.parseLong(st.nextToken());

        long count = 0;
        for (int i = 0; i < N; i++) {
            A[i] -= Math.min(A[i], B);
            count++;
            count += (A[i] / C);
            if (A[i] % C != 0) {
                count++;
            }
        }
        System.out.println(count);
    }
}