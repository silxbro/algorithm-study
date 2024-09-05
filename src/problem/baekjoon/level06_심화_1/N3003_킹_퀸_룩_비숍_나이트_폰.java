package src.problem.baekjoon.level06_심화_1;

import java.util.Scanner;

class N3003_킹_퀸_룩_비숍_나이트_폰 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] chess = {1, 1, 2, 2, 2, 8};
        for (int i = 0; i < chess.length; i++) {
            int plus = chess[i] - scanner.nextInt();
            System.out.print(plus + " ");
        }
    }

}