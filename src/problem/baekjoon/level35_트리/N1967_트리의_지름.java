package src.problem.baekjoon.level35_트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

class N1967_트리의_지름 {

    static List<TreeNode>[] tree;
    static long[] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        tree = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            tree[a].add(new TreeNode(b, v));
            tree[b].add(new TreeNode(a, v));
        }

        dist = new long[n + 1];
        Arrays.fill(dist, Long.MAX_VALUE);
        bfs(1);

        int maxNode = 1;
        for (int i = 2; i <= n; i++) {
            if (dist[i] > dist[maxNode]) {
                maxNode = i;
            }
        }

        dist = new long[n + 1];
        Arrays.fill(dist, Long.MAX_VALUE);
        bfs(maxNode);

        long maxValue = 0;
        for (int i = 1; i <= n; i++) {
            if (dist[i] > maxValue) {
                maxValue = dist[i];
            }
        }

        System.out.println(maxValue);
    }

    private static void bfs(int start) {
        dist[start] = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(new TreeNode(start, dist[start]));

        while (!queue.isEmpty()) {
            TreeNode now = queue.poll();
            for (TreeNode next : tree[now.number]) {
                if (dist[next.number] > now.edge + next.edge) {
                    dist[next.number] = now.edge + next.edge;
                    queue.add(new TreeNode(next.number, dist[next.number]));
                }
            }
        }
    }

}

class TreeNode {
    int number;
    long edge;
    TreeNode(int number, long edge) {
        this.number = number;
        this.edge = edge;
    }
}