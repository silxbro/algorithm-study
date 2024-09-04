package src.problem.baekjoon.level04_1차원_배열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class N10813_공_바꾸기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] buckets = new int[N + 1];
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = i;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int temp = buckets[a];
            buckets[a] = buckets[b];
            buckets[b] = temp;
        }

        for (int i = 1; i < buckets.length; i++) {
            System.out.print(buckets[i] + " ");
        }

        br.close();
    }
}