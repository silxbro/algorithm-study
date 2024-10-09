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
    static boolean[] visited;
    static int[] path;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];
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

        int path1 = 0;
        int path2 = 0;

        // 1 -> v1, v2 최단거리
        visited = new boolean[N + 1];
        path = new int[N + 1];
        Arrays.fill(path, Integer.MAX_VALUE);
        path[1] = 0;
        bfs(1);
        path1 += path[v1];
        path2 += path[v2];

        visited = new boolean[N + 1];
        path = new int[N + 1];
        Arrays.fill(path, Integer.MAX_VALUE);
        path[v1] = 0;
        bfs(v1);
        path1 += Math.max(path1, path[v2]) == Integer.MAX_VALUE ? Integer.MAX_VALUE - path1 : path[v2];
        path2 += Math.max(path2, path[v2]) == Integer.MAX_VALUE ? Integer.MAX_VALUE - path2 : path[v2];

        visited = new boolean[N + 1];
        path = new int[N + 1];
        Arrays.fill(path, Integer.MAX_VALUE);
        path[N] = 0;
        bfs(N);
        path1 += Math.max(path1, path[v2]) == Integer.MAX_VALUE ? Integer.MAX_VALUE - path1 : path[v2];
        path2 += Math.max(path2, path[v1]) == Integer.MAX_VALUE ? Integer.MAX_VALUE - path2 : path[v1];

        int answer = Math.min(path1, path2);
        System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
    }

    private static void bfs(int number) {
        PriorityQueue<NodeV> pq = new PriorityQueue<>();
        pq.add(new NodeV(number, path[number]));
        while (!pq.isEmpty()) {
            NodeV now = pq.poll();
            if (!visited[now.vertex]) {
                visited[now.vertex] = true;
                for (NodeV next : graph[now.vertex]) {
                    if (path[next.vertex] > now.distance + next.distance) {
                        path[next.vertex] = now.distance + next.distance;
                        pq.add(new NodeV(next.vertex, path[next.vertex]));
                    }
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