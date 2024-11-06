package src.problem.baekjoon.class02_silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class N20922_겹치는_건_싫어 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int maxLCS = 0;
        int lastIndex = 0;
        int[] count = new int[100001];
        int len = 0;
        for (int i = 0; i < N; i++) {
            if (count[arr[i]] == K) {
                count = new int[100001];
                len = 0;
                i = lastIndex + 1;
            }
            count[arr[i]]++;
            len++;
            maxLCS = Math.max(maxLCS, len);
            if (count[arr[i]] == K) {
                lastIndex = i;
            }
        }

        System.out.println(maxLCS);
    }
}