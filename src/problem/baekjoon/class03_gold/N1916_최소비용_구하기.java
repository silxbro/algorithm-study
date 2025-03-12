package src.problem.baekjoon.class03_gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class N1916_최소비용_구하기 {

    static int N, M;
    static List<Route>[] busRoutes;
    static int[] cost;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        busRoutes = new ArrayList[N + 1];
        cost = new int[N + 1];
        visited = new boolean[N + 1];

        Arrays.fill(cost, Integer.MAX_VALUE);
        for (int i = 0; i <= N; i++) {
            busRoutes[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            busRoutes[a].add(new Route(b, w));
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        calMinDistance(start);
        System.out.println(cost[end]);
    }

    private static void calMinDistance(int start) {
        PriorityQueue<Route> queue = new PriorityQueue<>();
        cost[start] = 0;
        queue.add(new Route(start, 0));
        while (!queue.isEmpty()) {
            Route now = queue.poll();
            if (visited[now.v]) {
                continue;
            }
            visited[now.v] = true;
            for (Route busRoute : busRoutes[now.v]) {
                if (cost[busRoute.v] > now.w + busRoute.w) {
                    cost[busRoute.v] = now.w + busRoute.w;
                    queue.add(new Route(busRoute.v, cost[busRoute.v]));
                }
            }
        }
    }
}

class Route implements Comparable<Route> {
    int v;
    int w;

    Route(int v, int w) {
        this.v = v;
        this.w = w;
    }

    @Override
    public int compareTo(Route o) {
        return w - o.w;
    }
}