package src.problem.baekjoon.level31_그래프와_순회;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

class N24480_알고리즘_수업_깊이_우선_탐색_2 {

    static List<Integer>[] graph;
    static int[] order;
    static boolean[] visited;
    static int nowOrder = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

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
            Collections.sort(graph[i], Collections.reverseOrder());
        }

        order = new int[N + 1];
        visited = new boolean[N + 1];

        dfs(R);

        StringBuilder stb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            stb.append(order[i]).append("\n");
        }
        System.out.println(stb);
    }

    private static void dfs(int now) {
        visited[now] = true;
        order[now] = nowOrder++;
        for (int next : graph[now]) {
            if (!visited[next]) {
                dfs(next);
            }
        }
    }
}