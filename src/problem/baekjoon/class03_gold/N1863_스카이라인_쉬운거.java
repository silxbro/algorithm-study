package src.problem.baekjoon.class03_gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;
import java.util.StringTokenizer;

class N1863_스카이라인_쉬운거 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[][] changes = new int[n][2];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            changes[i][0] = Integer.parseInt(st.nextToken());
            changes[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(changes, Comparator.comparing(o -> o[0]));

        int count = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            int height = changes[i][1];
            while (!stack.isEmpty() && stack.peek() > height) {
                stack.pop();
            }
            if (!stack.contains(height) && height > 0) {
                count++;
            }
            stack.push(height);
        }

        System.out.println(count);
    }
}