package src.problem.baekjoon.level16_스택_큐_덱;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

class N28279_덱_2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        Deque<Integer> deque = new LinkedList<>();
        StringBuilder stb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int command = Integer.parseInt(st.nextToken());
            if (command == 1) {
                deque.addFirst(Integer.parseInt(st.nextToken()));
                continue;
            }
            if (command == 2) {
                deque.addLast(Integer.parseInt(st.nextToken()));
                continue;
            }
            if (command == 3) {
                stb.append(deque.isEmpty() ? -1 : deque.pollFirst()).append("\n");
                continue;
            }
            if (command == 4) {
                stb.append(deque.isEmpty() ? -1 : deque.pollLast()).append("\n");
                continue;
            }
            if (command == 5) {
                stb.append(deque.size()).append("\n");
                continue;
            }
            if (command == 6) {
                stb.append(deque.isEmpty() ? 1 : 0).append("\n");
                continue;
            }
            if (command == 7) {
                stb.append(deque.isEmpty() ? -1 : deque.getFirst()).append("\n");
                continue;
            }
            if (command == 8) {
                stb.append(deque.isEmpty() ? -1 : deque.getLast()).append("\n");
            }
        }
        System.out.println(stb);
    }
}