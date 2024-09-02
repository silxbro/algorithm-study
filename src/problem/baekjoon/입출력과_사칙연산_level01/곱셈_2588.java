package src.problem.baekjoon.입출력과_사칙연산_level01;

import java.util.Scanner;

class 곱셈_2588 {

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