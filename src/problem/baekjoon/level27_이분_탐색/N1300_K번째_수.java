package src.problem.baekjoon.level27_이분_탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class N1300_K번째_수 {
    static long answer;
    static long N, k;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Long.parseLong(br.readLine());
        k = Long.parseLong(br.readLine());

        binarySearch(1, (long)Math.pow(N, 2));

        System.out.println(answer);

    }

    private static void binarySearch(long s, long e) {
        if (s <= e) {
            long m = (s + e) / 2;
            long count = 0;
            for (int i = 1; i <= N; i++) {
                count += Math.min(N, m / i);
            }

            if (count >= k) {
                answer = m;
                binarySearch(s, m - 1);
            } else {
                binarySearch(m + 1, e);
            }
        }
    }
}