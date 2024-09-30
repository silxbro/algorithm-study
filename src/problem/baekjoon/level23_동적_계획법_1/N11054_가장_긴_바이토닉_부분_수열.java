package src.problem.baekjoon.level23_동적_계획법_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class N11054_가장_긴_바이토닉_부분_수열 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] numbers = new int[N + 1];
        int[] upDp = new int[N + 1];
        int[] downDp = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= N; i++) {
            int now = numbers[i];
            for (int j = i - 1; j >= 0; j--) {
                if (numbers[j] < now) {
                    upDp[i] = Math.max(upDp[i], upDp[j] + 1);
                }
            }
        }
        for (int i = N; i >= 1; i--) {
            int now = numbers[i];
            for (int j = i + 1; j <= N; j++) {
                if (numbers[j] < now) {
                    downDp[i] = Math.max(downDp[i], downDp[j] + 1);
                }
            }
        }

        int maxLength = Integer.MIN_VALUE;
        for (int i = 1; i <= N; i++) {
            maxLength = Math.max(maxLength, upDp[i] + downDp[i]);
        }
        System.out.println(maxLength);
    }
}