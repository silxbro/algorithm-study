package src.problem.baekjoon.level03_반복문;

import java.util.Scanner;

class N8393_합 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int sum = 0;
        for (int num = 1; num <= n; num++) {
            sum += num;
        }
        System.out.println(sum);
    }

}