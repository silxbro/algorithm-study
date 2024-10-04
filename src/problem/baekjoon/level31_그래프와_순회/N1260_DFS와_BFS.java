package src.problem.baekjoon.level31_그래프와_순회;

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

    static List<Integer>[] graph;
    static boolean[] visited;
    static StringBuilder stb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];
        stb = new StringBuilder();

        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }

        for (int i = 1; i < graph.length; i++) {
            Collections.sort(graph[i]);
        }

        visited = new boolean[N + 1];
        dfs(V);

        stb.append("\n");

        visited = new boolean[N + 1];
        bfs(V);

        System.out.println(stb);
    }

    private static void dfs(int number) {
        visited[number] = true;
        stb.append(number).append(" ");
        for (int next : graph[number]) {
            if (!visited[next]) {
                dfs(next);
            }
        }
    }

    private static void bfs(int number) {
        Queue<Integer> queue = new LinkedList<>();
        visited[number] = true;
        stb.append(number).append(" ");
        queue.add(number);
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