package src.problem.baekjoon.level28_우선순위_큐;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

class N11286_절댓값_힙 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> {
            int first = Math.abs(o1);
            int second = Math.abs(o2);
            if (first == second) {
                return o1 - o2;
            }
            return first - second;
        });

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