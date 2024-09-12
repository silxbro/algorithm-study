package src.problem.baekjoon.level16_스택_큐_덱;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.stream.Collectors;

class N11866_요세푸스_문제_0 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int K = scanner.nextInt();

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            queue.add(i);
        }

        int count = 0;
        List<Integer> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            count++;
            if (count == K) {
                result.add(queue.poll());
                count = 0;
                continue;
            }
            queue.add(queue.poll());
        }

        System.out.println("<" + result.stream().map(String::valueOf).collect(Collectors.joining(", ")) + ">");
    }
}