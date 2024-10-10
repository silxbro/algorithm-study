package src.problem.baekjoon.level30_스택_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

class N17299_오등큰수 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        int[] count = new int[1000001];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int now = Integer.parseInt(st.nextToken());
            count[now]++;
            A[i] = now;
        }

        int[] answer = new int[N];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < N; i++) {
            while (!stack.isEmpty() && count[A[stack.peek()]] < count[A[i]]) {
                answer[stack.pop()] = A[i];
            }
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            answer[stack.pop()] = -1;
        }

        StringBuffer stb = new StringBuffer();
        for (int i = 0; i < N; i++) {
            stb.append(answer[i]).append(" ");
        }
        System.out.println(stb);
    }
}