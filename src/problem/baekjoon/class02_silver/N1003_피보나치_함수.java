package src.problem.baekjoon.class02_silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class N1003_피보나치_함수 {

    public static void main(String[] args) throws IOException {
        int[] zeroCount = new int[41];
        int[] oneCount = new int[41];
        zeroCount[0] = 1;
        oneCount[1] = 1;

        for (int i = 2; i <= 40; i++) {
            zeroCount[i] = zeroCount[i - 1] + zeroCount[i - 2];
            oneCount[i] = oneCount[i - 1] + oneCount[i - 2];
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder stb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            int n = Integer.parseInt(br.readLine());
            stb.append(zeroCount[n]).append(" ").append(oneCount[n]).append("\n");
        }
        System.out.println(stb);
    }
}