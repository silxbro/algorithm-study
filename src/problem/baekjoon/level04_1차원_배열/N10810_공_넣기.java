package src.problem.baekjoon.level04_1차원_배열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class N10810_공_넣기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] buckets = new int[N + 1];

        for (int count = 0; count < M; count++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int number = Integer.parseInt(st.nextToken());
            for (int bucket = start; bucket <= end; bucket++) {
                buckets[bucket] = number;
            }
        }

        for (int bucket = 1; bucket < buckets.length; bucket++) {
            System.out.print(buckets[bucket] + " ");
        }

        br.close();
    }

}