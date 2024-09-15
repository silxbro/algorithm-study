package src.problem.baekjoon.level19_조합론;

import java.util.Scanner;

class N11050_이항_계수_1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int K = scanner.nextInt();
        System.out.println(factorial(N) / factorial(K) / factorial(N - K));
    }

    private static long factorial(long number) {
        if (number == 0) {
            return 1;
        }
        return number * factorial(number - 1);
    }
}