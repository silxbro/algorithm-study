package src.problem.baekjoon.level05_문자열;

import java.util.Scanner;

class N2908_상수 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int first = Integer.parseInt(new StringBuilder(scanner.next()).reverse().toString());
        int second = Integer.parseInt(new StringBuilder(scanner.next()).reverse().toString());

        System.out.println(Math.max(first, second));
    }

}