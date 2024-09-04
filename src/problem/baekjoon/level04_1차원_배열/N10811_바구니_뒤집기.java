package src.problem.baekjoon.level04_1차원_배열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class N10811_바구니_뒤집기 {

    static int[] buckets;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        buckets = new int[N + 1];
        for (int i = 1; i < buckets.length; i++) {
            buckets[i] = i;
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            reverseBuckets(start, end);
        }
        for (int i = 1; i < buckets.length; i++) {
            System.out.print(buckets[i] + " ");
        }

        br.close();
    }

    private static void reverseBuckets(int start, int end) {
        int i = start;
        int e = end;
        while (i < e) {
            int temp = buckets[i];
            buckets[i] = buckets[e];
            buckets[e] = temp;
            i++;
            e--;
        }
    }
}