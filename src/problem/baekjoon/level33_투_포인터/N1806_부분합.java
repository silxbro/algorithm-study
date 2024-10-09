package src.problem.baekjoon.level33_투_포인터;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class N1806_부분합 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int minLength = Integer.MAX_VALUE;
        int s = 0;
        int e = 0;
        int sum = arr[0];
        while (s <= e) {
            if (sum >= S) {
                minLength = Math.min(minLength, e - s + 1);
                sum -= arr[s];
                s++;
            } else if (e < N - 1) {
                e++;
                sum += arr[e];
            } else {
                break;
            }
            if (minLength == 1) {
                break;
            }
        }
        if (minLength == Integer.MAX_VALUE) {
            minLength = 0;
        }
        System.out.println(minLength);
    }
}