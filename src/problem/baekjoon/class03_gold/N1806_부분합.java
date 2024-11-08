package src.problem.baekjoon.class03_gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class N1806_부분합 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        long S = Long.parseLong(st.nextToken());
        long[] cumSum = new long[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            cumSum[i] = cumSum[i - 1] + Integer.parseInt(st.nextToken());
        }

        int minLen = Integer.MAX_VALUE;
        int s = 0;
        int e = 1;
        while (s < e && e <= N) {
            long sum = cumSum[e] - cumSum[s];
            if (sum >= S) {
                minLen = Math.min(minLen, e - s);
                s++;
            } else {
                e++;
            }
        }
        System.out.println(minLen == Integer.MAX_VALUE ? 0 : minLen);
    }
}