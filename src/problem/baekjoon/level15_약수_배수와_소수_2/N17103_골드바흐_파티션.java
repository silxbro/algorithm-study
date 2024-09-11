package src.problem.baekjoon.level15_약수_배수와_소수_2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class N17103_골드바흐_파티션 {

    public static void main(String[] args) throws IOException {
        boolean[] isPrime = new boolean[1000001];
        for (int i = 2; i < isPrime.length; i++) {
            isPrime[i] = true;
        }
        for (int i = 2; i * i <= 1000000; i++) {
            if (isPrime[i]) {
                for (int j = i + i; j < isPrime.length; j += i) {
                    isPrime[j] = false;
                }
            }
        }


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int count = 0;
            int number = Integer.parseInt(br.readLine());
            for (int n = 2; n <= number / 2; n++) {
                if (isPrime[n] && isPrime[number - n]) {
                    count++;
                }
            }
            bw.write(count + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}