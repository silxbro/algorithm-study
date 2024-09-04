package src.problem.baekjoon.level04_1차원_배열;

import java.util.Scanner;

class N5597_과제_안_내신_분 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean[] students = new boolean[31];
        for (int i = 0; i < 28; i++) {
            students[scanner.nextInt()] = true;
        }

        for (int i = 1; i <= 30; i++) {
            if (!students[i]) {
                System.out.println(i);
            }
        }
    }

}