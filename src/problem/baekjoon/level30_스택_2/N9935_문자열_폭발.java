package src.problem.baekjoon.level30_스택_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

class N9935_문자열_폭발 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String target = br.readLine();

        Deque<Integer> deque = new LinkedList<>();
        StringBuilder answer = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            int index = target.indexOf(String.valueOf(c));
            if (index == 0 || !deque.isEmpty() && (deque.getLast() == target.indexOf(String.valueOf(c)) - 1)) {
                deque.addLast(index);
                if (deque.getLast() == target.length() - 1) {
                    for (int j = 0; j < target.length(); j++) {
                        deque.removeLast();
                    }
                }
            } else {
                while (!deque.isEmpty()) {
                    answer.append(target.charAt(deque.removeFirst()));
                }
                answer.append(c);
            }
        }

        while (!deque.isEmpty()) {
            answer.append(target.charAt(deque.removeFirst()));
        }

        if (answer.length() == 0) {
            System.out.println("FRULA");
        } else {
            System.out.println(answer);
        }
    }
}