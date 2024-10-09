package src.problem.baekjoon.level32_최단_경로;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class N1504_특정한_최단_경로 {

    static List<NodeV>[] graph;
    static int[] dist;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];
        dist = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph[a].add(new NodeV(b, c));
            graph[b].add(new NodeV(a, c));
        }

        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        System.out.println(Math.min(getPath(1, v1, v2, N), getPath(1, v2, v1, N)));
    }

    private static int getPath(int s, int m1, int m2, int e) {
        int minPath = 0;
        int[] positions = {s, m1, m2, e};
        for (int i = 0; i < 3; i++) {
            dijkstra(positions[i]);
            if (dist[positions[i + 1]] == Integer.MAX_VALUE) {
                return -1;
            }
            minPath += dist[positions[i + 1]];
        }
        return minPath;
    }

    private static void dijkstra(int number) {
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[number] = 0;
        PriorityQueue<NodeV> queue = new PriorityQueue<>();
        queue.add(new NodeV(number, 0));

        while (!queue.isEmpty()) {
            NodeV now = queue.poll();
            if (dist[now.vertex] < now.distance) {
                continue;
            }
            for (NodeV next : graph[now.vertex]) {
                if (dist[next.vertex] > now.distance + next.distance) {
                    dist[next.vertex] = now.distance + next.distance;
                    queue.add(new NodeV(next.vertex, dist[next.vertex]));
                }
            }
        }
    }
}

class NodeV implements Comparable<NodeV> {
    int vertex;
    int distance;

    NodeV(int vertex, int distance) {
        this.vertex = vertex;
        this.distance = distance;
    }

    @Override
    public int compareTo(NodeV o) {
        return distance - o.distance;
    }
}