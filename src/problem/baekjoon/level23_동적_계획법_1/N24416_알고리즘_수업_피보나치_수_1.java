package src.problem.baekjoon.level23_동적_계획법_1;

import java.util.Scanner;

class N24416_알고리즘_수업_피보나치_수_1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] fib = new int[n + 1];
        fib[1] = 1;
        fib[2] = 1;
        for (int i = 3; i <= n; i++) {
            fib[i] = fib[i - 1] + fib[i - 2];
        }

        StringBuilder stb = new StringBuilder();
        stb.append(fib[n]).append(" ").append(n - 2);

        System.out.println(stb);
    }
}