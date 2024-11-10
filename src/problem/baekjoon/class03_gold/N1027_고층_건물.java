package src.problem.baekjoon.class03_gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class N1027_고층_건물 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] result = new int[N];
        for (int i = 0; i < N; i++) {
            double maxInc = Integer.MIN_VALUE;
            for (int j = i - 1; j >= 0; j--) {
                double inc = (double)(arr[j] - arr[i]) / (i - j);
                if (inc > maxInc) {
                    result[i]++;
                    result[j]++;
                    maxInc = inc;
                }
            }
        }

        int answer = 0;
        for (int i = 0; i < N; i++) {
            answer = Math.max(answer, result[i]);
        }
        System.out.println(answer);
    }
}