package src.problem.baekjoon.level31_그래프와_순회;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class N1707_이분_그래프 {

    static List<Integer>[] graph;
    static boolean[] visited;
    static int[] group;
    static boolean isEven;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder stb = new StringBuilder();

        int K = Integer.parseInt(br.readLine());
        for (int k = 0; k < K; k++) {
            st = new StringTokenizer(br.readLine());
            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            graph = new ArrayList[V + 1];
            for (int i = 0; i <= V; i++) {
                graph[i] = new ArrayList<>();
            }
            for (int i = 0; i < E; i++) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                graph[u].add(v);
                graph[v].add(u);
            }
            isEven = true;
            group = new int[V + 1];
            visited = new boolean[V + 1];
            for (int i = 1; i <= V; i++) {
                if (!visited[i]) {
                    dfs(i);
                }
                if (!isEven) {
                    break;
                }
            }
            stb.append(isEven ? "YES" : "NO").append("\n");
        }
        System.out.println(stb);
    }

    private static void dfs(int now) {
        visited[now] = true;
        for (int next : graph[now]) {
            if (!visited[next]) {
                group[next] = (group[now] + 1) % 2;
                dfs(next);
            }
            if (group[now] == group[next]) {
                isEven = false;
            }
        }
    }
}