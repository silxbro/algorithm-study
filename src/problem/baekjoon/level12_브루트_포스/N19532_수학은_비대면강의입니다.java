package src.problem.baekjoon.level12_브루트_포스;

import java.util.Scanner;

class N19532_수학은_비대면강의입니다 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        int d = scanner.nextInt();
        int e = scanner.nextInt();
        int f = scanner.nextInt();

        int denominator = a * e - b * d;    // 유일한 해가 존재하므로, 0이 아닌 수
        int x = (c * e - b * f) / denominator;
        int y = (a * f - c * d) / denominator;

        System.out.println(x + " " + y);
    }
}