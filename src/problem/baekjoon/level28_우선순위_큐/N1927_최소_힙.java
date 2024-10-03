package src.problem.baekjoon.level28_우선순위_큐;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

class N1927_최소_힙 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        StringBuilder stb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            int command = Integer.parseInt(br.readLine());
            if (command == 0) {
                stb.append(pq.isEmpty() ? 0 : pq.poll()).append("\n");
                continue;
            }
            pq.add(command);
        }
        System.out.println(stb);
    }
}