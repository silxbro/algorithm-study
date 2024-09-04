package src.problem.baekjoon.level05_문자열;

import java.util.Scanner;

class N11720_숫자의_합 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        String str = scanner.next();
        int sum = 0;
        for (int i = 0; i < N; i++) {
            sum += str.charAt(i) - '0';
        }

        System.out.println(sum);
    }
}