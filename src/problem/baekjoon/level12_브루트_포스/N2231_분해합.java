package src.problem.baekjoon.level12_브루트_포스;

import java.util.Scanner;

class N2231_분해합 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int answer = 0;
        for (int n = 1; n <= N; n++) {
            int num = n;
            int sum = n;
            while (num > 0) {
                sum += num % 10;
                num /= 10;
            }
            if (sum == N) {
                answer = n;
                break;
            }
        }
        System.out.println(answer);
    }
}