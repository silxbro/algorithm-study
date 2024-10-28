package src.problem.baekjoon.level27_이분_탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class N2805_나무_자르기 {

    static int M, N;
    static long[] heights;
    static long answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        long max = 0;

        heights = new long[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            heights[i] = Long.parseLong(st.nextToken());
            max = Math.max(max, heights[i]);
        }

        binarySearch(0, max);

        System.out.println(answer);
    }

    private static void binarySearch(long s, long e) {
        if (s <= e) {
            long m = (s + e) / 2;
            long remain = 0;
            for (long height : heights) {
                remain += Math.max(0, height - m);
            }

            if (remain >= M) {
                answer = m;
                binarySearch(m + 1, e);
            } else {
                binarySearch(s, m - 1);
            }
        }
    }
}