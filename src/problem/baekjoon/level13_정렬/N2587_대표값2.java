package src.problem.baekjoon.level13_정렬;

import java.util.Arrays;
import java.util.Scanner;

class N2587_대표값2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] arr = new int[5];
        int sum = 0;
        for (int i = 0; i < 5; i++) {
            arr[i] = scanner.nextInt();
            sum += arr[i];
        }
        Arrays.sort(arr);
        System.out.println(sum / 5);
        System.out.println(arr[5 / 2]);
    }
}