package src.problem.baekjoon.level08_일반_수학_1;

import java.util.Scanner;

class N2903_중앙_이동_알고리즘 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        long[] len = new long[N + 1];
        len[0] = 2;
        for (int i = 1; i < len.length; i++) {
            len[i] = len[i - 1] * 2 - 1;
        }
        System.out.println(len[N] * len[N]);
    }
}