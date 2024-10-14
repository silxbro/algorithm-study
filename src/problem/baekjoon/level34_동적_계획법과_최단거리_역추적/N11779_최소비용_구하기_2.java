package src.problem.baekjoon.level34_동적_계획법과_최단거리_역추적;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.StringTokenizer;

class N11779_최소비용_구하기_2 {

    static List<Node>[] graph;
    static int[] cost;
    static int[] parent;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        graph = new ArrayList[n + 1];
        cost = new int[n + 1];
        parent = new int[n + 1];
        visited = new boolean[n + 1];
        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
            cost[i] = Integer.MAX_VALUE;
            parent[i] = i;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph[s].add(new Node(e, c));
        }

        st = new StringTokenizer(br.readLine());
        int startCity = Integer.parseInt(st.nextToken());
        int endCity = Integer.parseInt(st.nextToken());

        bfs(startCity);

        StringBuilder stb = new StringBuilder();
        stb.append(cost[endCity]).append("\n");

        Stack<Integer> visited = new Stack<>();
        int nowCity = endCity;
        while (nowCity != startCity) {
            visited.push(nowCity);
            nowCity = parent[nowCity];
        }
        visited.push(startCity);

        stb.append(visited.size()).append("\n");
        while (!visited.isEmpty()) {
            stb.append(visited.pop()).append(" ");
        }
        System.out.println(stb);
    }

    private static void bfs(int start) {
        cost[start] = 0;
        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(start, 0));
        while (!queue.isEmpty()) {
            Node now = queue.poll();
            if (!visited[now.city]) {
                visited[now.city] = true;
                for (Node next : graph[now.city]) {
                    if (cost[next.city] > cost[now.city] + next.cost) {
                        cost[next.city] = cost[now.city] + next.cost;
                        parent[next.city] = now.city;
                        queue.add(new Node(next.city, cost[next.city]));
                    }
                }
            }
        }
    }
}

class Node implements Comparable<Node> {
    int city;
    int cost;

    Node(int city, int cost) {
        this.city = city;
        this.cost = cost;
    }

    @Override
    public int compareTo(Node o) {
        return cost - o.cost;
    }
}
