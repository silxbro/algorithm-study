package src.problem.baekjoon.level37_최소_신장_트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class N4386_별자리_만들기 {

    static double[][] stars;
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        stars = new double[n][2];
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        PriorityQueue<EdgeS> queue = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            stars[i][0] = Double.parseDouble(st.nextToken());
            stars[i][1] = Double.parseDouble(st.nextToken());
            for (int j = 0; j < i; j++) {
                queue.add(new EdgeS(i, j, getDist(i, j)));
            }
        }

        int len = 0;
        double answer = 0;
        while (!queue.isEmpty() && len < n - 1) {
            EdgeS edge = queue.poll();
            if (!sameGroup(edge.a, edge.b)) {
                union(edge.a, edge.b);
                len++;
                answer += edge.v;
            }
        }
        System.out.println(answer);
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

    private static boolean sameGroup(int a, int b) {
        return find(a) == find(b);
    }

    private static double getDist(int a, int b) {
        return Math.sqrt(Math.pow(stars[a][0] - stars[b][0], 2) + Math.pow(stars[a][1] - stars[b][1], 2));
    }

}

class EdgeS implements Comparable<EdgeS> {
    int a;
    int b;
    double v;

    EdgeS(int a, int b, double v) {
        this.a = a;
        this.b = b;
        this.v = v;
    }

    @Override
    public int compareTo(EdgeS o) {
        return (int)(v - o.v);
    }
}