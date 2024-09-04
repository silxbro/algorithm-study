package src.problem.baekjoon.level04_1차원_배열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class N1546_평균 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int sum = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            int score = Integer.parseInt(st.nextToken());
            sum += score;
            max = Math.max(max, score);
        }
        br.close();

        System.out.println(sum * 100.0 / max / N);
    }
}