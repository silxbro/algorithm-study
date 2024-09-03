package src.problem.baekjoon.level01_입출력과_사칙연산;

import java.util.Scanner;

class N2588_곱셈 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int first = scanner.nextInt();
        int second = scanner.nextInt();

        System.out.println(first * (second % 10));
        System.out.println(first * ((second / 10) % 10));
        System.out.println(first * (second / 100));
        System.out.println(first * second);
    }

}