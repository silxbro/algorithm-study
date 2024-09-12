package src.problem.baekjoon.level16_스택_큐_덱;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

class N12789_도키도키_간식드리미 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        Stack<Integer> waiting = new Stack<>();
        int order = 1;
        for (int i = 0; i < N; i++) {
            while (!waiting.isEmpty() && waiting.peek() == order) {
                waiting.pop();
                order++;
            }
            int now = Integer.parseInt(st.nextToken());
            if (now != order) {
                waiting.push(now);
                continue;
            }
            order++;
        }
        while (!waiting.isEmpty()) {
            int now = waiting.pop();
            if (now != order) {
                System.out.println("Sad");
                return;
            }
            order++;
        }
        System.out.println("Nice");
    }
}