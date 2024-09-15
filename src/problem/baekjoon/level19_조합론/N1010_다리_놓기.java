package src.problem.baekjoon.level19_조합론;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class N1010_다리_놓기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        StringBuilder stb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            N = Math.min(N, M - N);
            //M개의 중 N개를 고르는 경우의 수
            long molecule = 1;
            long denominator = 1;
            while (N >= 1) {
                molecule *= M;
                denominator *= N;
                M--;
                N--;
            }
            stb.append(molecule / denominator).append("\n");
        }
        System.out.println(stb);
    }
}