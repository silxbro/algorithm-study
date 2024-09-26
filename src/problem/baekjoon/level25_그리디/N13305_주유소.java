package src.problem.baekjoon.level25_그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class N13305_주유소 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        long[] D = new long[N];
        long[] C = new long[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N - 1; i++) {
            D[i] = Long.parseLong(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            C[i] = Long.parseLong(st.nextToken());
        }

        long totalCost = 0;
        long minCost = Long.MAX_VALUE;

        for(int i = 0; i < N - 1; i++) {
            minCost = Math.min(minCost, C[i]);
            totalCost += minCost * D[i];
        }

        System.out.println(totalCost);
    }
}