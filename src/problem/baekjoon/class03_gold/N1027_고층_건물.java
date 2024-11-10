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
        double[] arr = new double[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Double.parseDouble(st.nextToken());
        }

        int answer = 0;
        for (int i = 0; i < N; i++) {
            int count = 0;
            double maxInc = Integer.MIN_VALUE;
            for (int j = i - 1; j >= 0; j--) {
                double inc = (arr[j] - arr[i]) / (i - j);
                if (inc > maxInc) {
                    maxInc = inc;
                    count++;
                }
            }
            maxInc = Integer.MIN_VALUE;
            for (int j = i + 1; j < N; j++) {
                double inc = (arr[j] - arr[i]) / (j - i);
                if (inc > maxInc) {
                    maxInc = inc;
                    count++;
                }
            }
            answer = Math.max(answer, count);
        }
        System.out.println(answer);
    }
}