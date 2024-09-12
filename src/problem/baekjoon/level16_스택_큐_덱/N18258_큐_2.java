package src.problem.baekjoon.level16_스택_큐_덱;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

class N18258_큐_2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        Deque<Integer> queue = new LinkedList<>();
        StringBuilder stb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            if (command.equals("push")) {
                queue.addLast(Integer.parseInt(st.nextToken()));
                continue;
            }
            if (command.equals("pop")) {
                stb.append(queue.isEmpty() ? "-1" : queue.pollFirst()).append("\n");
                continue;
            }
            if (command.equals("size")) {
                stb.append(queue.size()).append("\n");
                continue;
            }
            if (command.equals("empty")) {
                stb.append(queue.isEmpty() ? "1" : "0").append("\n");
                continue;
            }
            if (command.equals("front")) {
                stb.append(queue.isEmpty() ? "-1" : queue.getFirst()).append("\n");
                continue;
            }
            if (command.equals("back")) {
                stb.append(queue.isEmpty() ? "-1" : queue.getLast()).append("\n");
            }
        }
        System.out.println(stb);
    }
}