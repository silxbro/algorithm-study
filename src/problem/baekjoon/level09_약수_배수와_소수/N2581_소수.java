package src.problem.baekjoon.level09_약수_배수와_소수;

import java.util.Scanner;

class N2581_소수 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();

        boolean[] check = new boolean[b + 1];
        check[1] = true;

        for (int i = 2; i <= b / 2; i++) {
            for (int j = 2; j * i <= b; j++) {
                check[i * j] = true;
            }
        }

        int sum = 0;
        int min = -1;
        for (int i = a; i <= b; i++) {
            if (!check[i]) {
                if (min == -1) {
                    min = i;
                }
                sum += i;
            }
        }
        if (sum == 0) {
            System.out.println(-1);
            return;
        }
        System.out.println(sum);
        System.out.println(min);
    }
}