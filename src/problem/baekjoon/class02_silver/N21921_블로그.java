package src.problem.baekjoon.class02_silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class N21921_블로그 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        long[] S = new long[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            S[i] += S[i - 1] + Integer.parseInt(st.nextToken());
        }

        long max = Long.MIN_VALUE;
        int count = 0;
        for (int i = X; i <= N; i++) {
            long sum = S[i] - S[i - X];
            if (sum > max) {
                max = sum;
                count = 0;
            }
            if (sum == max) {
                count++;
            }
        }

        if (max == 0) {
            System.out.println("SAD");
            return;
        }
        System.out.println(max);
        System.out.println(count);
    }
}