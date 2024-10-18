package src.problem.baekjoon.level37_최소_신장_트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class N6497_전력난 {

    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        StringBuilder stb = new StringBuilder();

        while (true) {
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            if (m == 0 && n == 0) {
                break;
            }

            parent = new int[m];
            for (int i = 0; i < m; i++) {
                parent[i] = i;
            }

            int total = 0;
            PriorityQueue<EdgeE> queue = new PriorityQueue<>(Comparator.comparing(edge -> edge.v));
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                queue.add(new EdgeE(a, b, v));
                total += v;
            }

            int len = 0;
            int min = 0;
            while (!queue.isEmpty() && len < m - 1) {
                EdgeE edge = queue.poll();
                if (!checkSame(edge.a, edge.b)) {
                    union(edge.a, edge.b);
                    len++;
                    min += edge.v;
                }
            }
            stb.append(total - min).append("\n");
        }
        System.out.println(stb);
    }

    private static void union(int a, int b) {
        a = find(a);
        b = find(b);
        parent[b] = a;
    }

    private static int find(int a) {
        if (a == parent[a]) {
            return a;
        }
        return parent[a] = find(parent[a]);
    }

    private static boolean checkSame(int a, int b) {
        return find(a) == find(b);
    }

}

class EdgeE {
    int a;
    int b;
    int v;
    EdgeE(int a, int b, int v) {
        this.a = a;
        this.b = b;
        this.v = v;
    }
}