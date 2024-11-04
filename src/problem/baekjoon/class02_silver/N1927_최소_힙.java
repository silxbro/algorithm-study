package src.problem.baekjoon.class02_silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

class N1927_최소_힙 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        StringBuilder stb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            if (num == 0) {
                stb.append(queue.isEmpty() ? 0 : queue.poll()).append("\n");
            } else {
                queue.add(num);
            }
        }
        System.out.println(stb);
    }
}