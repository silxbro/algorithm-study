package src.problem.baekjoon.class02_silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class N8979_올림픽 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        PriorityQueue<Node> queue = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int gold = Integer.parseInt(st.nextToken());
            int silver = Integer.parseInt(st.nextToken());
            int bronze = Integer.parseInt(st.nextToken());
            queue.add(new Node(num, gold, silver, bronze, num == K));
        }

        int index = 1;
        while (!queue.isEmpty()) {
            Node now = queue.poll();
            if (now.num == K) {
                System.out.println(index);
                return;
            }
            index++;
        }
    }

}

class Node implements Comparable<Node> {
    int num;
    int gold;
    int silver;
    int bronze;
    boolean target;

    Node (int num, int gold, int silver, int bronze, boolean target) {
        this.num = num;
        this.gold = gold;
        this.silver = silver;
        this.bronze = bronze;
        this.target = target;
    }

    @Override
    public int compareTo(Node o) {
        if (gold == o.gold && silver == o.silver && bronze == o.bronze) {
            return target ? 0 : 1;
        }
        if (gold == o.gold && silver == o.silver) {
            return o.bronze - bronze;
        }
        if (gold == o.gold) {
            return o.silver - silver;
        }
        return o.gold - gold;
    }
}
