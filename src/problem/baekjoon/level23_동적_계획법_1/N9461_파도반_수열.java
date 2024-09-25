package src.problem.baekjoon.level23_동적_계획법_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class N9461_파도반_수열 {

    public static void main(String[] args) throws IOException {
        long[] P = new long[101];
        P[1] = 1;
        P[2] = 1;
        for (int n = 3; n <= 100; n++) {
            P[n] = P[n - 2] + P[n - 3];
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder stb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            stb.append(P[N]).append("\n");
        }
        System.out.println(stb);
    }
}