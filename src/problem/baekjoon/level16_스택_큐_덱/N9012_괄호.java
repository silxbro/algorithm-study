package src.problem.baekjoon.level16_스택_큐_덱;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

class N9012_괄호 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder stb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            String str = br.readLine();
            stb.append(isVPS(str) ? "YES" : "NO").append("\n");
        }
        System.out.println(stb);
    }

    private static boolean isVPS(String str) {
        boolean isVPC = true;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            Character c = str.charAt(i);
            if (c == ')') {
                if (stack.isEmpty() || stack.peek() == ')') {
                    return false;
                }
                stack.pop();
                continue;
            }
            stack.push(c);
        }
        if (!stack.isEmpty()) {
            return false;
        }
        return true;
    }
}