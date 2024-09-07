package src.problem.baekjoon.level11_시간_복잡도;

import java.util.Scanner;

class N24265_알고리즘_수업_알고리즘의_수행_시간_4 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextInt();
        long count = 0;
        for (int i = 1; i < n; i++) {
            count += (n - i);
        }
        System.out.println(count);
        System.out.println(2);
    }
}