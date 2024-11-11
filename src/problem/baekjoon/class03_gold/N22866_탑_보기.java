package src.problem.baekjoon.class03_gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

class N22866_탑_보기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N  = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] leftNearest = new int[N];
        int[] rightNearest = new int[N];
        int[] count = new int[N];

        Stack<Integer> stack = new Stack<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            while (!stack.isEmpty() && arr[stack.peek()] <= arr[i]) {
                stack.pop();
            }
            leftNearest[i] = stack.isEmpty() ? Integer.MAX_VALUE : stack.peek() + 1;
            count[i] += stack.size();
            stack.push(i);
        }

        stack.clear();

        for (int i = N - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] <= arr[i]) {
                stack.pop();
            }
            rightNearest[i] = stack.isEmpty() ? Integer.MAX_VALUE : stack.peek() + 1;
            count[i] += stack.size();
            stack.push(i);
        }

        StringBuilder stb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            stb.append(count[i]);
            if (count[i] > 0) {
                int nearest = Math.abs(leftNearest[i] - i - 1) <= Math.abs(rightNearest[i] - i - 1) ? leftNearest[i] : rightNearest[i];
                stb.append(" ").append(nearest);
            }
            stb.append("\n");
        }

        System.out.println(stb);
    }
}