package src.problem.baekjoon.class03_gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

class N1655_가운데를_말해요 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> smaller = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> bigger = new PriorityQueue<>();


        StringBuilder stb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            if (smaller.size() == bigger.size()) {
                if (!bigger.isEmpty() && num > bigger.peek()) {
                    smaller.add(bigger.poll());
                    bigger.add(num);
                } else {
                    smaller.add(num);
                }
            }
            if (smaller.size() > bigger.size()) {
                if (num < smaller.peek()) {
                    bigger.add(smaller.poll());
                    smaller.add(num);
                } else {
                    bigger.add(num);
                }
            }

            stb.append(smaller.peek()).append("\n");
        }

        System.out.println(stb);
    }
}