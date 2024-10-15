package src.problem.baekjoon.level35_트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class N11725_트리의_부모_찾기 {

    static List<Integer>[] tree;
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        tree = new ArrayList[N + 1];
        parent = new int[N + 1];

        for (int i = 0; i <= N; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            tree[a].add(b);
            tree[b].add(a);
        }

        parent[1] = -1;
        dfs(1);

        StringBuilder stb = new StringBuilder();
        for (int i = 2; i <= N; i++) {
            stb.append(parent[i]).append("\n");
        }

        System.out.println(stb);
    }

    private static void dfs(int node) {
        for (int next : tree[node]) {
            if (parent[next] == 0) {
                parent[next] = node;
                dfs(next);
            }
        }
    }
}