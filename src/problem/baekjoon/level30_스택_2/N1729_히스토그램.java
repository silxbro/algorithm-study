package src.problem.baekjoon.level30_스택_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

class N1729_히스토그램 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] A = new int[N];
        int[] maxLen = new int[N];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(br.readLine());
            while (!stack.isEmpty() && A[stack.peek()] > A[i]) {
                maxLen[stack.pop()] = i;
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            maxLen[stack.pop()] = N;
        }
        for (int i = N - 1; i >= 0; i--) {
            while (!stack.isEmpty() && A[stack.peek()] > A[i]) {
                maxLen[stack.pop()] -= i + 1;
            }
            stack.push(i);
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            max = Math.max(max, A[i] * maxLen[i]);
        }
        System.out.println(max);
    }
}