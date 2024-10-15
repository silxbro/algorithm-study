package src.problem.baekjoon.level35_트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class N4803_트리 {

    static List<Integer>[] graph;
    static boolean[] visited;
    static boolean cycle;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder stb = new StringBuilder();

        int testCase = 0;
        while (true) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            if (n == 0 && m == 0) {
                break;
            }
            testCase++;
            graph = new ArrayList[n + 1];
            for (int i = 0; i <= n; i++) {
                graph[i] = new ArrayList<>();
            }

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                graph[a].add(b);
                graph[b].add(a);
            }

            visited = new boolean[n + 1];
            int tree = 0;
            for (int i = 1; i <= n; i++) {
                if (!visited[i]) {
                    cycle = false;
                    dfs(i, -1);
                    if (!cycle) {
                        tree++;
                    }
                }
            }

            if (tree > 1) {
                stb.append(String.format("Case %d: A forest of %d trees.", testCase, tree));
            } else if (tree == 1) {
                stb.append(String.format("Case %d: There is one tree.", testCase));
            } else if (tree == 0) {
                stb.append(String.format("Case %d: No trees.", testCase));
            }
            stb.append("\n");
        }

        System.out.println(stb);
    }

    private static void dfs(int now, int parent) {
        visited[now] = true;
        for (int next : graph[now]) {
            if (visited[next] && next != parent) {
                cycle = true;
            }
            else if (!visited[next]) {
                dfs(next, now);
            }
        }
    }
}