package src.problem.baekjoon.level21_재귀;

import java.util.Scanner;

class N27433_팩토리얼_2 {

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