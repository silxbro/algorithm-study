package src.problem.baekjoon.level23_동적_계획법_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class N1149_RGB거리 {

    static int[][] cost;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        cost = new int[N][3];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            cost[i][0] = Integer.parseInt(st.nextToken());
            cost[i][1] = Integer.parseInt(st.nextToken());
            cost[i][2] = Integer.parseInt(st.nextToken());
        }

        int[][] minCost = new int[N][3];
        minCost[0][0] = cost[0][0];
        minCost[0][1] = cost[0][1];
        minCost[0][2] = cost[0][2];

        for (int i = 1; i < minCost.length; i++) {
            minCost[i][0] = Math.min(minCost[i - 1][1] + cost[i][0], minCost[i - 1][2] + cost[i][0]);
            minCost[i][1] = Math.min(minCost[i - 1][0] + cost[i][1], minCost[i - 1][2] + cost[i][1]);
            minCost[i][2] = Math.min(minCost[i - 1][0] + cost[i][2], minCost[i - 1][1] + cost[i][2]);
        }

        System.out.println(Math.min(minCost[N - 1][0], Math.min(minCost[N - 1][1],minCost[N - 1][2])));
    }
}