package src.problem.baekjoon.level37_최소_신장_트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class N1197_최소_스패닝_트리 {

    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        parent = new int[V + 1];
        for (int i = 1; i <= V; i++) {
            parent[i] = i;
        }

        PriorityQueue<Edge> queue = new PriorityQueue<>();
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            queue.add(new Edge(a, b, e));
        }

        int len = 0;
        int answer = 0;
        while (len < V - 1) {
            Edge e = queue.poll();
            if (!sameGroup(e.n1, e.n2)) {
                union(e.n1, e.n2);
                len++;
                answer += e.edge;
            }
        }
        System.out.println(answer);
    }

    private static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a != b) {
            parent[b] = a;
        }
    }

    private static int find(int a) {
        if (a == parent[a]) {
            return a;
        }
        return parent[a] = find(parent[a]);
    }

    private static boolean sameGroup(int a, int b) {
        return (find(a) == find(b));
    }
}

class Edge implements Comparable<Edge> {
    int n1;
    int n2;
    int edge;

    Edge(int n1, int n2, int edge) {
        this.n1 = n1;
        this.n2 = n2;
        this.edge = edge;
    }

    @Override
    public int compareTo(Edge o) {
        return edge - o.edge;
    }
}