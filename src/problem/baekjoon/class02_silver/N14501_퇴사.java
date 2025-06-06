package src.problem.baekjoon.class02_silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N14501_퇴사 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] T = new int[N];
        int[] P = new int[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }

        int[] maxR = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 0; j < i; j++) {
                maxR[i] = Math.max(maxR[i], maxR[j] + (i >= j + T[j] ? P[j] : 0));
            }
        }

        System.out.println(maxR[N]);
    }
}