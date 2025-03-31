package src.problem.baekjoon.class03_gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N16637_괄호_추가하기 {

    static int N;
    static int[] arr;
    static char[] opr;
    static int answer;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        String line = br.readLine();

        int numCount = N / 2 + 1;
        int oprCount = N / 2 + 1;
        arr = new int[numCount];
        opr = new char[oprCount];
        opr[0] = '+';

        for (int i = 0; i < N; i++) {
            if (i % 2 == 0) {
                arr[i / 2] = line.charAt(i) - '0';
            } else {
                opr[i / 2 + 1] = line.charAt(i);
            }
        }

        answer = Integer.MIN_VALUE;
        backtrack(1, 0);

        System.out.println(answer);
    }

    private static void backtrack(int index, int sum) {
        if (index > arr.length) {
            answer = Math.max(answer, sum);
            return;
        }

        //괄호 선택 X
        backtrack(index + 1, operate(sum, arr[index - 1], opr[index - 1]));
        if (index < arr.length) {
            //괄호 선택 O
            int plus = operate(arr[index - 1], arr[index], opr[index]);
            backtrack(index + 2, operate(sum, plus, opr[index - 1]));
        }

    }

    private static int operate(int a, int b, char opr) {
        if (opr == '+') return a + b;
        if (opr == '-') return a - b;
        return a * b;
    }
}