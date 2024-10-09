package src.problem.baekjoon.level33_투_포인터;

import java.util.Arrays;
import java.util.Scanner;

class N1644_소수의_연속합 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();

        int[] prime = new int[4000001];
        for (int i = 2; i <= 4000000; i++) {
            prime[i] = i;
        }

        for (int i = 2; i <= Math.sqrt(4000000); i++) {
            if (prime[i] == i) {
                for (int j = i + i; j < prime.length; j+=i) {
                    prime[j] = 0;
                }
            }
        }

        int[] primeArr = Arrays.stream(prime).filter(num -> num > 0).toArray();

        int s = 0;
        int e = 0;
        int count = 0;
        int sum = primeArr[0];
        while (s <= e) {
            if (sum == N) {
                count++;
                sum -= primeArr[s];
                s++;
            } else if (sum > N) {
                sum -= primeArr[s];
                s++;
            } else if (e < primeArr.length - 1) {
                e++;
                sum += primeArr[e];
            } else {
                break;
            }
        }

        System.out.println(count);
    }
}