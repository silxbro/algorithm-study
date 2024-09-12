package src.problem.baekjoon.level16_스택_큐_덱;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

class N28278_스택_2 {

    public static void main(String[] args) throws IOException {
        Stack<Integer> stack = new Stack<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int command = Integer.parseInt(st.nextToken());
            if (command == 1) {
                stack.push(Integer.parseInt(st.nextToken()));
                continue;
            }
            int result = 0;
            if (command == 2) {
                result = stack.isEmpty() ? -1 : stack.pop();
            }
            else if (command == 3) {
                result = stack.size();
            }
            else if (command == 4) {
                result = stack.isEmpty() ? 1 : 0;
            }
            else {
                result = stack.isEmpty() ? -1 : stack.peek();
            }
            bw.write(result + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}