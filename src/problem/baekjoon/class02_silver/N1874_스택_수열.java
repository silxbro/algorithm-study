package src.problem.baekjoon.class02_silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class N1874_스택_수열 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();

        int n = Integer.parseInt(br.readLine());
        int num = 1;
        for (int i = 0; i < n; i++) {
            int now = Integer.parseInt(br.readLine());
            while (stack.isEmpty() || stack.peek() < now) {
                stack.push(num);
                stb.append("+").append("\n");
                num++;
            }
            if (stack.peek() > now) {
                System.out.println("NO");
                return;
            }
            stack.pop();
            stb.append("-").append("\n");
        }
        System.out.println(stb);
    }
}