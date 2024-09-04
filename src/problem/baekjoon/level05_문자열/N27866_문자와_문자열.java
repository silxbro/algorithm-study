package src.problem.baekjoon.level05_문자열;

import java.util.Scanner;

class N27866_문자와_문자열 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        int order = scanner.nextInt();
        System.out.println(str.charAt(order - 1));
    }
}