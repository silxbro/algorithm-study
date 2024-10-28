package src.problem.baekjoon.level27_이분_탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class N1654_랜선_자르기 {

    static int[] arr;
    static long answer;
    static int K, N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        int max = 0;

        arr = new int[K];
        for (int i = 0; i < K; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, arr[i]);
        }

        binarySearch(1, max);

        System.out.println(answer);
    }

    private static void binarySearch(long s, long e) {
        if (s <= e) {
            long m = (s + e) / 2;
            long count = 0;
            for (int i = 0; i < K; i++) {
                count += arr[i] / m;
            }

            if (count >= N) {
                answer = m;
                binarySearch(m + 1, e);
            } else {
                binarySearch(s, m - 1);
            }
        }
    }
}