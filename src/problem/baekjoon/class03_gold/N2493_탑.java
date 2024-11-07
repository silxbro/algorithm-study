package src.problem.baekjoon.class03_gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

class N2493_탑 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N + 1];
        int[] answer = new int[N + 1];
        Stack<Integer> stack = new Stack<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                answer[i] = stack.peek();
            }
            stack.push(i);
        }
        StringBuilder stb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            stb.append(answer[i]).append(" ");
        }
        System.out.println(stb);
    }
}
