package src.problem.baekjoon.level19_조합론;

import java.util.Scanner;

class N10872_팩토리얼 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();

        System.out.println(factorial(N));
    }

    private static long factorial(long number) {
        if (number == 0) {
            return 1;
        }
        return number * factorial(number - 1);
    }
}