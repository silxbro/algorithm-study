package src.problem.baekjoon.class02_silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class N13305_주유소 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int[] dist = new int[N - 1];
        int[] cost = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N - 1; i++) {
            dist[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            cost[i] = Integer.parseInt(st.nextToken());
        }

        long totalCost = 0;
        long minCost = Long.MAX_VALUE;
        for (int i = 0; i < N - 1; i++) {
            minCost = Math.min(minCost, cost[i]);
            totalCost += dist[i] * minCost;
        }
        System.out.println(totalCost);
    }
}