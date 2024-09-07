package src.problem.baekjoon.level10_기하_직사각형과_삼각형;

import java.util.Scanner;

class N14215_세_막대 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();

        int max = Math.max(a, Math.max(b, c));
        int sum = a + b + c;
        int remain = sum - max;

        System.out.println(Math.min(max, remain - 1) + remain);
    }
}