package src.problem.baekjoon.level06_심화_1;

import java.util.Scanner;

class N2444_별_찍기_7 {

    static int N;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();

        int number = 1;

        while (number <= N) {
            printStars(number);
            number++;
        }
        number -= 2;
        while (number >= 1) {
            printStars(number);
            number--;
        }
    }

    private static void printStars(int number) {
        String star = "*".repeat(2 * number - 1);
        String space = " ".repeat(N - number);
        System.out.println(space + star);
    }
}