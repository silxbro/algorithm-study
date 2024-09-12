package src.problem.baekjoon.level16_스택_큐_덱;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class N2164_카드2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();

        Queue<Integer> cards = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            cards.add(i);
        }

        while (cards.size() > 1) {
            cards.poll();
            cards.add(cards.poll());
        }

        System.out.println(cards.poll());
    }
}