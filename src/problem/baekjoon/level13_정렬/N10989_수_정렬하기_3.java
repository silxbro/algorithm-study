package src.problem.baekjoon.level13_정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class N10989_수_정렬하기_3 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stb = new StringBuilder();

        int[] count = new int[10001];
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            count[Integer.parseInt(br.readLine())]++;
        }

        for (int i = 1; i < count.length; i++) {
            if (count[i] > 0) {
                stb.append((i  + "\n").repeat(count[i]));
            }
        }
        System.out.println(stb);
    }
}