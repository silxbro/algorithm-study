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

class N1167_트리의_지름 {

    static List<Node>[] tree;
    static long[] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int V = Integer.parseInt(br.readLine());
        tree = new ArrayList[V + 1];
        for (int i = 0; i <= V; i++) {
            tree[i] = new ArrayList<>();
        }
        for (int i = 0; i < V; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            while (true) {
                int b = Integer.parseInt(st.nextToken());
                if (b == -1) {
                    break;
                }
                int e = Integer.parseInt(st.nextToken());
                tree[a].add(new Node(b, e));
            }
        }

        dist = new long[V + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[1] = 0;
        bfs(1);

        int maxNode = 1;
        for (int i = 2; i <= V; i++) {
            if (dist[i] > dist[maxNode]) {
                maxNode = i;
            }
        }

        dist = new long[V + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[maxNode] = 0;
        bfs(maxNode);

        long answer = 0;
        for (int i = 1; i <= V; i++) {
            if (dist[i] > answer) {
                answer = dist[i];
            }
        }

        System.out.println(answer);
    }

    private static void bfs(int start) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(start, 0));

        while (!queue.isEmpty()) {
            Node now = queue.poll();
            for (Node next : tree[now.number]) {
                if (dist[next.number] > now.edge + next.edge) {
                    dist[next.number] = now.edge + next.edge;
                    queue.add(new Node(next.number, dist[next.number]));
                }
            }
        }
    }
}

class Node {
    int number;
    long edge;

    Node(int number, long edge) {
        this.number = number;
        this.edge = edge;
    }
}
