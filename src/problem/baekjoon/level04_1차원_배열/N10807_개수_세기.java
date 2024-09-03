package src.problem.baekjoon.level04_1차원_배열;

import java.util.Scanner;

class N10807_개수_세기 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] array = new int[N];
        for (int n = 0; n < N; n++) {
            array[n] = scanner.nextInt();
        }
        int v = scanner.nextInt();
        int count = 0;
        for (int n = 0; n < N; n++) {
            if (v == array[n]) {
                count++;
            }
        }
        System.out.println(count);
    }
}