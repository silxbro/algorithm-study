package src.problem.baekjoon.level37_최소_신장_트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class N1774_우주신과의_교감 {

    static int[][] gods;
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        gods = new int[N + 1][2];
        parent = new int[N + 1];
        PriorityQueue<EdgeU> queue = new PriorityQueue<>(Comparator.comparing(edge -> edge.v));
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            parent[i] = i;
            gods[i][0] = Integer.parseInt(st.nextToken());
            gods[i][1] = Integer.parseInt(st.nextToken());
            for (int j = 1; j < i; j++) {
                queue.add(new EdgeU(i, j, getDist(i, j)));
            }
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            queue.add(new EdgeU(a, b, 0));
        }

        int len = 0;
        double answer = 0;
        while (!queue.isEmpty() && len < N - 1) {
            EdgeU edge = queue.poll();
            if (!checkSame(edge.a, edge.b)) {
                union(edge.a, edge.b);
                len++;
                answer += edge.v;
            }
        }

        System.out.printf("%.2f", answer);
    }

    private static double getDist(int a, int b) {
        double temp = Math.pow((long)(gods[a][0] - gods[b][0]), 2) + Math.pow((long)(gods[a][1] - gods[b][1]), 2);
        return Math.sqrt(temp);
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

class EdgeU  {
    int a;
    int b;
    double v;

    EdgeU(int a, int b, double v) {
        this.a = a;
        this.b = b;
        this.v = v;
    }
}