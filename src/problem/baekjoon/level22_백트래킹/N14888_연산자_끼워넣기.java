package src.problem.baekjoon.level22_백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class N14888_연산자_끼워넣기 {

    static int N;
    static int max, min;
    static int[] numbers, operations;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        numbers = new int[N];
        operations = new int[4];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            operations[i] = Integer.parseInt(st.nextToken());
        }

        max = Integer.MIN_VALUE;
        min = Integer.MAX_VALUE;

        backtrack(1, numbers[0]);

        System.out.println(max);
        System.out.println(min);
    }

    private static void backtrack(int index, int value) {
        if (index == N) {
            max = Math.max(max, value);
            min = Math.min(min, value);
            return;
        }
        int number = numbers[index];
        for (int i = 0; i < 4; i++) {
            if (operations[i] > 0) {
                operations[i]--;
                switch (i) {
                    case 0: backtrack(index + 1, value + number); break;
                    case 1: backtrack(index + 1, value - number); break;
                    case 2: backtrack(index + 1, value * number); break;
                    case 3: backtrack(index + 1, value / number); break;
                }
                operations[i]++;
            }
        }
    }
}