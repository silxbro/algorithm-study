package src.problem.baekjoon.level16_스택_큐_덱;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

class N4949_균형잡힌_세상 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stb = new StringBuilder();
        while(true) {
            String line = br.readLine();
            if (line.equals(".")) {
                break;
            }

            stb.append(isBalanced(line)).append("\n");
        }
        System.out.println(stb);
    }

    private static String isBalanced(String line) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < line.length(); i++) {
            Character c = line.charAt(i);
            if (c == ']' || c == ')') {
                if (stack.isEmpty()) {
                    return "no";
                }
                Character up = stack.pop();
                if ((c == ']' && up != '[') || (c == ')' && up != '(')) {
                    return "no";
                }
                continue;
            }
            if (c == '[' || c == '(') {
                stack.push(c);
            }
        }
        if (!stack.isEmpty()) {
            return "no";
        }
        return "yes";
    }
}