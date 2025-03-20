package src.problem.baekjoon.class03_gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class N1744_수_묶기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> plusQueue = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> minusQueue = new PriorityQueue<>();
        int zero = 0;

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            if (num > 0) {
                plusQueue.add(num);
            } else if (num < 0) {
                minusQueue.add(num);
            } else {
                zero++;
            }
        }

        int answer = 0;
        while (plusQueue.size() > 1) {
            int first = plusQueue.poll();
            int second = plusQueue.poll();
            if (first * second > first + second) {
                answer += first * second;
            } else {
                answer += first;
                plusQueue.add(second);
            }

        }
        if (!plusQueue.isEmpty()) {
            answer += plusQueue.poll();
        }
        while (minusQueue.size() > 1) {
            int first = minusQueue.poll();
            int second = minusQueue.poll();
            answer += first * second;
        }
        if (!minusQueue.isEmpty() && zero == 0) {
            answer += minusQueue.poll();
        }
        System.out.println(answer);
    }
}