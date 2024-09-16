package src.problem.baekjoon.level21_재귀;

import java.util.Scanner;

class N10870_피보나치_수_5 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        System.out.println(fibonacci(N));
    }

    private static long fibonacci(long number) {
        if (number <= 1) {
            return number;
        }
        return fibonacci(number - 1) + fibonacci(number - 2);
    }
}