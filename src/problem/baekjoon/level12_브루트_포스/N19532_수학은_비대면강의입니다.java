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

        int x = (c * e - b * f) / (a * e - b * d);
        int y = b != 0 ? (c - a * x) / b : (f - d * x) / e;

        System.out.println(x + " " + y);
    }
}