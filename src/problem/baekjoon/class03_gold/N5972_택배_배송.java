package src.problem.baekjoon.class03_gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class N5972_택배_배송 {

    static List<Node>[] graph;
    static boolean[] visited;
    static int[] cost;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        graph = new ArrayList[N + 1];
        visited = new boolean[N + 1];
        cost = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        Arrays.fill(cost, Integer.MAX_VALUE);

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph[a].add(new Node(b, c));
            graph[b].add(new Node(a, c));
        }

        bfs(1);

        System.out.println(cost[N]);
    }

    private static void bfs(int start) {
        cost[start] = 0;
        PriorityQueue<Node> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o.cost));
        queue.add(new Node(start, 0));
        while (!queue.isEmpty()) {
            Node now = queue.poll();
            if (!visited[now.vertex]) {
                visited[now.vertex] = true;
                for (Node next : graph[now.vertex]) {
                    if (cost[next.vertex] > now.cost + next.cost) {
                        cost[next.vertex] = now.cost + next.cost;
                        queue.add(new Node(next.vertex, cost[next.vertex]));
                    }
                }
            }
        }
    }
}

class Node {
    int vertex;
    int cost;
    Node (int vertex, int cost) {
        this.vertex = vertex;
        this.cost = cost;
    }
}
