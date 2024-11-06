package src.problem.baekjoon.class02_silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class N1446_지름길 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        List<Road>[] graph = new ArrayList[10001];
        int[] dp = new int[10001];
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
            dp[i] = i;
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph[e].add(new Road(s, w));
        }

        for (int i = 1; i <= D; i++) {
            for (Road road : graph[i]) {
                dp[i] = Math.min(dp[i], dp[road.v] + road.w);
            }
            dp[i] = Math.min(dp[i], dp[i - 1] + 1);
        }
        System.out.println(dp[D]);
    }
}

class Road {
    int v;
    int w;
    Road(int v, int w) {
        this.v = v;
        this.w = w;
    }
}