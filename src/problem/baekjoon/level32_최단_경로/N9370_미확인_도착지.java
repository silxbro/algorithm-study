package src.problem.baekjoon.level32_최단_경로;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

class N9370_미확인_도착지 {

    static List<NodeR>[] graph;
    static int[] dist;
    static boolean[] passedBy;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder stb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int test = 0; test < T; test++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());   // 교차로
            int m = Integer.parseInt(st.nextToken());   // 도로
            int t = Integer.parseInt(st.nextToken());   // 목적지 후보

            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());   // 출발지
            int g = Integer.parseInt(st.nextToken());   // 지나간 도로의 양끝 교차로 1
            int h = Integer.parseInt(st.nextToken());   // 지나간 도로의 양끝 교차로 2

            graph = new ArrayList[n + 1];
            for (int i = 0; i <= n; i++) {
                graph[i] = new ArrayList<>();
            }

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int d = Integer.parseInt(st.nextToken());
                boolean p = a == g && b == h || a == h && b == g;
                graph[a].add(new NodeR(b, d, p));
                graph[b].add(new NodeR(a, d, p));
            }

            dist = new int[n + 1];
            passedBy = new boolean[n + 1];
            dijkstra(s);

            List<Integer> answer = new ArrayList<>();
            for (int i = 0; i < t; i++) {
                int x = Integer.parseInt(br.readLine());
                if (passedBy[x]) {
                    answer.add(x);
                }
            }

            stb.append(answer.stream().sorted().map(String::valueOf).collect(Collectors.joining(" "))).append("\n");
        }
        System.out.println(stb);
    }

    private static void dijkstra(int start) {
        Arrays.fill(dist, Integer.MAX_VALUE);
        PriorityQueue<NodeR> queue = new PriorityQueue<>();
        dist[start] = 0;
        queue.add(new NodeR(start, 0, false));
        while (!queue.isEmpty()) {
            NodeR now = queue.poll();
            if (dist[now.vertex] < now.distance) {
                continue;
            }

            for (NodeR next : graph[now.vertex]) {
                int newDist = now.distance + next.distance;
                boolean pass = now.passedBy || next.passedBy;
                if (dist[next.vertex] > newDist) {
                    dist[next.vertex] = newDist;
                    passedBy[next.vertex] = pass;
                    queue.add(new NodeR(next.vertex, dist[next.vertex], pass));
                }
                // 생각하지 못한 지점 : 최단 경로가 여러 가지일 때
                else if (dist[next.vertex] == newDist && pass && !passedBy[next.vertex]) {  // 다시보기
                    passedBy[next.vertex] = true;
                    queue.add(new NodeR(next.vertex, dist[next.vertex], true));
                }
            }
        }
    }
}

class NodeR implements Comparable<NodeR> {
    int vertex;
    int distance;
    boolean passedBy;
    NodeR(int vertex, int distance, boolean passedBy) {
        this.vertex = vertex;
        this.distance = distance;
        this.passedBy = passedBy;
    }

    @Override
    public int compareTo(NodeR o) {
        return distance - o.distance;
    }
}