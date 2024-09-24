package src.problem.baekjoon.level22_백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class N14888_연산자_끼워넣기 {

    static int N;
    static int max;
    static int min;
    static int[] numbers, operations;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        numbers = new int[N];
        operations = new int[N - 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        int index = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= 4; i++) {
            int repeat = Integer.parseInt(st.nextToken());
            for (int j = 0; j < repeat; j++) {
                operations[index++] = i;
            }
        }

        max = Integer.MIN_VALUE;
        min = Integer.MAX_VALUE;

        backtrack(0, new ArrayList<>(), numbers[0]);
        System.out.println(max);
        System.out.println(min);
    }

    private static void backtrack(int order, List<Integer> operated, int value) {
        if (operated.size() == N - 1) {
            max = Math.max(max, value);
            min = Math.min(min, value);
            return;
        }
        for (int i = 0; i < N - 1; i++) {
            if (!operated.contains(i)) {
                int newValue = operate(operations[i], value, numbers[order + 1]);
                List<Integer> newOperated = new ArrayList<>(operated);
                newOperated.add(i);
                backtrack(order + 1, newOperated, newValue);
            }
        }
    }

    private static int operate(int operation, int number1, int number2) {
        if (operation == 1) {
            return number1 + number2;
        }
        if (operation == 2) {
            return number1 - number2;
        }
        if (operation == 3) {
            return number1 * number2;
        }
        if (number1 < 0) {
            return - (Math.abs(number1) / number2);
        }
        return number1 / number2;
    }
}
