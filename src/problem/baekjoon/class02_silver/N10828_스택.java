package src.problem.baekjoon.class02_silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

class N10828_스택 {

    static Stack<Integer> stack;

    public static void main(String[] args) throws IOException {

        stack = new Stack<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        StringBuilder stb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String operation = st.nextToken();
            if (operation.equals("push")) {
                stack.push(Integer.parseInt(st.nextToken()));
                continue;
            }
            stb.append(getResult(operation)).append("\n");
        }
        System.out.println(stb);
    }

    private static int getResult(String operation) {
        switch (operation) {
            case "pop":
                return stack.isEmpty() ? -1 : stack.pop();
            case "size":
                return stack.size();
            case "empty":
                return stack.isEmpty() ? 1 : 0;
            case "top":
                return stack.isEmpty() ? -1 : stack.peek();
        }
        return 0;
    }
}