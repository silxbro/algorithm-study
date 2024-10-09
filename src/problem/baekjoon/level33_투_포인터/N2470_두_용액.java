package src.problem.baekjoon.level33_투_포인터;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class N2470_두_용액 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] values = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            values[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(values);

        PriorityQueue<Node> queue = new PriorityQueue<>();
        int s = 0;
        int e = N - 1;
        while (s < e) {
            queue.add(new Node(values[s], values[e]));
            if (values[s] + values[e] == 0) {
                break;
            }

            int next1 = Math.abs(values[s + 1] + values[e]);
            int next2 = Math.abs(values[s] + values[e - 1]);
            if (next1 < next2) {
                s++;
            } else {
                e--;
            }
        }
        System.out.println(queue.peek().getString());
    }
}

class Node implements Comparable<Node> {
    int value1;
    int value2;

    Node (int value1, int value2) {
        this.value1 = value1;
        this.value2 = value2;
    }

    public String getString() {
        int min = Math.min(value1, value2);
        int max = Math.max(value1, value2);
        return min + " " + max;
    }
    @Override
    public int compareTo(Node o) {
        int myAbs = Math.abs(value1 + value2);
        int otherAbs = Math.abs(o.value1 + o.value2);
        return myAbs - otherAbs;
    }
}