package src.problem.baekjoon.level03_반복문;

import java.util.Scanner;

class N2439_별_찍기_2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();

        for (int n = 1; n <= N; n++) {
            System.out.println(" ".repeat(N - n) + "*".repeat(n));
        }
    }

}