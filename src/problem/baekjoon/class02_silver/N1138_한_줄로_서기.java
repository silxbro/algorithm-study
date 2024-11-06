package src.problem.baekjoon.class02_silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;
import java.util.StringTokenizer;

class N1138_한_줄로_서기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Deque<Integer> deque = new LinkedList<>();
        Stack<Integer> stack = new Stack<>();

        for (int i = N; i >= 1; i--) {
            while (deque.size() > arr[i]) {
                stack.push(deque.removeLast());
            }
            deque.add(i);
            while (!stack.isEmpty()) {
                deque.addLast(stack.pop());
            }
        }

        StringBuilder stb = new StringBuilder();
        while (!deque.isEmpty()) {
            stb.append(deque.removeFirst()).append(" ");
        }
        System.out.println(stb);
    }
}