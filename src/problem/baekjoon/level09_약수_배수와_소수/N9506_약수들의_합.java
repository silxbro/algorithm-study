package src.problem.baekjoon.level09_약수_배수와_소수;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class N9506_약수들의_합 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == -1) {
                break;
            }
            bw.write(getPerfectSentence(n) + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    private static String getPerfectSentence(int number) {
        int sum = 0;
        List<Integer> divisors = new ArrayList<>();
        for (int i = 1; i < number; i++) {
            if (number % i == 0) {
                sum += i;
                divisors.add(i);
            }
        }
        if (sum == number) {
            String plusDivisors = divisors.stream().map(String::valueOf).collect(Collectors.joining(" + "));
            return number + " = " + plusDivisors;
        }
        return number + " is NOT perfect.";
    }
}