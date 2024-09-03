package src.problem.baekjoon.반복문_level03;

import java.util.Scanner;

class 합_8393 {

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