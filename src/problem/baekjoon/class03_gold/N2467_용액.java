package src.problem.baekjoon.class03_gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class N2467_용액 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        long[] arr = new long[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(arr);

        long minAbs = Long.MAX_VALUE;
        long[] answer = new long[2];

        int s = 0;
        int e = N - 1;
        while (s < e) {
            long abs = Math.abs(arr[s] + arr[e]);
            if (minAbs >= abs) {
                minAbs = abs;
                answer[0] = arr[s];
                answer[1] = arr[e];
            }
            if (minAbs == 0) {
                break;
            }
            if (Math.abs(arr[s]) < Math.abs(arr[e])) {
                e--;
            } else if (Math.abs(arr[s]) > Math.abs(arr[e])) {
                s++;
            }
        }
        System.out.println(answer[0] + " " + answer[1]);
    }
}