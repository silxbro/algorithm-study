package src.problem.baekjoon.class02_silver;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class N1158_요세푸스_문제 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int K = scanner.nextInt();
        Queue<Integer> queue = new ArrayDeque<>();

        for (int i = 1; i <= N; i++) {
            queue.add(i);
        }

        StringBuilder stb = new StringBuilder("<");
        while (!queue.isEmpty()) {
            for (int k = 1; k < K; k++) {
                queue.add(queue.poll());
            }
            stb.append(queue.poll());
            if (queue.isEmpty()) {
                break;
            }
            stb.append(", ");
        }

        stb.append(">");
        System.out.println(stb);
    }
}