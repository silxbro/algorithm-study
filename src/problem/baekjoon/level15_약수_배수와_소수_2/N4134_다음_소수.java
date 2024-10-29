package src.problem.baekjoon.level15_약수_배수와_소수_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class N4134_다음_소수 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long T = Long.parseLong(br.readLine());

        StringBuilder stb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            long N = Long.parseLong(br.readLine());
            while (!isPrime(N)) {
                N++;
            }
            stb.append(N).append("\n");
        }

        System.out.println(stb);
    }

    private static boolean isPrime(long num) {
        if (num <= 1) {
            return false;
        }
        for (long n = 2; n <= Math.sqrt(num); n++) {
            if (num % n == 0) {
                return false;
            }
        }
        return true;
    }
}