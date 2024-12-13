package src.problem.baekjoon.class02_silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

class N10845_큐 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        Deque<Integer> queue = new LinkedList<>();
        StringBuilder stb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            switch (command) {
                case "push":
                    queue.add(Integer.parseInt(st.nextToken()));
                    break;
                case "pop":
                    stb.append(queue.isEmpty() ? -1 : queue.poll()).append("\n");
                    break;
                case "size":
                    stb.append(queue.size()).append("\n");
                    break;
                case "empty":
                    stb.append(queue.isEmpty() ? 1 : 0).append("\n");
                    break;
                case "front":
                    stb.append(queue.isEmpty() ? -1 : queue.peek()).append("\n");
                    break;
                case "back":
                    stb.append(queue.isEmpty() ? -1 : queue.getLast()).append("\n");
                    break;
            }
        }
        System.out.println(stb);
    }
}