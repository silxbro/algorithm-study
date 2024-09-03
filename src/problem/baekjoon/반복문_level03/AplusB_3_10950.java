package src.problem.baekjoon.반복문_level03;

import java.util.Scanner;

class AplusB_3_10950 {

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