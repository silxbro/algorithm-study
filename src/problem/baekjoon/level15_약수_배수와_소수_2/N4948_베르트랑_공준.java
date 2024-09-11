package src.problem.baekjoon.level15_약수_배수와_소수_2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class N4948_베르트랑_공준 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) {
                break;
            }
            bw.write(primeCount(n) + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    private static int primeCount(int number) {
        boolean[] isPrime = new boolean[2 * number + 1];
        for (int i = 2; i < isPrime.length; i++) {
            isPrime[i] = true;  // 1을 제외한 모든 자연수가 소수라고 가정
        }

        for (int i = 2; i * i <= 2 * number; i++) {
            if (isPrime[i]) {
                for (int j = i + i; j <= 2 * number; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        int count = 0;
        for (int i = number + 1; i <= number * 2; i++) {
            if (isPrime[i]) {
                count++;
            }
        }
        return count;
    }
}