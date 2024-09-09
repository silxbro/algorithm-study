package src.problem.baekjoon.level12_브루트_포스;

import java.util.Scanner;

class N2231_분해합 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int answer = 0;
        int start = N - 9 * String.valueOf(N).length(); // 각 자릿수가 모두 9이면서 N의 자릿수와 동일할 때 최솟값

        for (int n = start; n <= N; n++) {
            int num = n;
            int sum = n;    // 분해합
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