package src.problem.baekjoon.level03_반복문;

import java.util.Scanner;

class N10950_AplusB_3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();

        for (int test = 0; test < T; test++) {
            int A = scanner.nextInt();
            int B = scanner.nextInt();
            System.out.println(A + B);
        }
    }

}