package src.problem.baekjoon.반복문_level03;

import java.util.Scanner;

class 별_찍기_2_2439 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();

        for (int n = 1; n <= N; n++) {
            System.out.println(" ".repeat(N - n) + "*".repeat(n));
        }
    }

}