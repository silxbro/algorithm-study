package src.problem.baekjoon.level15_약수_배수와_소수_2;

import java.util.Scanner;

class N1929_소수_구하기 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int M = scanner.nextInt();
        int N = scanner.nextInt();

        int[] primeCheck = new int[N - M + 1];
        for (int i = 0; i < primeCheck.length; i++) {
            primeCheck[i] = i + M;
        }
        for (int i = 2; i * i <= N; i++) {
            int firstIndex = M / i;
            if (M % i != 0) {
                firstIndex++;
            }
            for (int j = Math.max(firstIndex, 2); j * i <= N; j++) {
                primeCheck[j * i - M] = 0;
            }
        }

        StringBuilder stb = new StringBuilder();
        for (int i = 0; i < primeCheck.length; i++) {
            if (primeCheck[i] > 1) {
                stb.append(i + M).append("\n");
            }
        }
        System.out.println(stb);
    }
}