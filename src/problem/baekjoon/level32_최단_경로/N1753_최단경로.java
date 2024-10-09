package src.problem.baekjoon.level32_최단_경로;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class N1753_최단경로 {

    static List<Node>[] graph;
    static int[] path;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        int K = Integer.parseInt(br.readLine());

        graph = new ArrayList[V + 1];
        path = new int[V + 1];
        visited = new boolean[V + 1];
        Arrays.fill(path, Integer.MAX_VALUE);

        for (int i = 0; i <= V; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph[u].add(new Node(v,w));
        }

        path[K] = 0;
        bfs(K);

        StringBuilder stb = new StringBuilder();
        for (int i = 1; i <= V; i++) {
            stb.append(path[i] == Integer.MAX_VALUE ? "INF" : path[i]).append("\n");
        }
        System.out.println(stb);
    }

    private static void bfs(int number) {
        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(number, 0));
        while (!queue.isEmpty()) {
            Node now = queue.poll();
            if (!visited[now.target]) {
                visited[now.target] = true;
                for (Node next : graph[now.target]) {
                    if (path[next.target] > path[now.target] + next.weight) {
                        path[next.target] = path[now.target] + next.weight;
                        queue.add(new Node(next.target, path[next.target]));
                    }
                }
            }
        }
    }
}

class Node implements Comparable<Node> {
    int target;
    int weight;

    Node(int target, int weight) {
        this.target = target;
        this.weight = weight;
    }

    @Override
    public int compareTo(Node o) {
        return weight - o.weight;
    }
}