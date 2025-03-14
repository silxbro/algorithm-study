package src.problem.baekjoon.class03_gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class N1068_트리 {

    static int N;
    static List<Integer>[] tree;
    static int remove;
    static int root;
    static int leafCount;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        tree = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            tree[i] = new ArrayList<>();
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int parent = Integer.parseInt(st.nextToken());
            if (parent == -1) {
                root = i;
            } else {
                tree[parent].add(i);
            }
        }

        remove = Integer.parseInt(br.readLine());

        if (root == remove) {
            System.out.println(0);
            return;
        }
        dfs(root);
        System.out.println(leafCount);
    }

    private static void dfs(int node) {
        int count = 0;
        for (int next : tree[node]) {
            if (next != remove) {
                count++;
                dfs(next);
            }
        }
        if (count == 0) {
            leafCount++;
        }
    }
}