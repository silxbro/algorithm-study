package src.problem.baekjoon.level09_약수_배수와_소수;

import java.util.Scanner;

class N2501_약수_구하기 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int K = scanner.nextInt();

        System.out.println(find(N, K));
    }

    private static int find(int number, int findOrder) {
        int count = 0;
        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                count++;
                if (count == findOrder) {
                    return i;
                }
            }
        }
        return 0;
    }
}