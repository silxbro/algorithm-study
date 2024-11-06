package src.problem.baekjoon.class02_silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

class N1260_DFS와_BFS {

    static int N, M, V;
    static List<Integer>[] graph;
    static boolean[] visited;
    static StringBuilder stb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }

        for (int i = 1; i <= N; i++) {
            Collections.sort(graph[i]);
        }

        stb = new StringBuilder();
        visited = new boolean[N + 1];
        DFS(V);
        stb.append("\n");
        visited = new boolean[N + 1];
        BFS(V);
        System.out.println(stb);
    }

    private static void DFS(int node) {
        visited[node] = true;
        stb.append(node).append(" ");
        for (int next : graph[node]) {
            if (!visited[next]) {
                DFS(next);
            }
        }
    }

    private static void BFS(int node) {
        stb.append(node).append(" ");
        Queue<Integer> queue = new LinkedList<>();
        visited[node] = true;
        queue.add(node);
        while (!queue.isEmpty()) {
            int now = queue.poll();
            for (int next : graph[now]) {
                if (!visited[next]) {
                    visited[next] = true;
                    stb.append(next).append(" ");
                    queue.add(next);
                }
            }
        }
    }
}