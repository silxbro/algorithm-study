package src.problem.baekjoon.class03_gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N2230_수_고르기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        int answer = 2000000000;
        int index1 = 0;
        int index2 = 0;
        while (index1 <= index2 && index1 < N && index2 < N) {
            int diff = arr[index2] - arr[index1];
            if (diff == M) {
                answer = M;
                break;
            }
            if (diff > M) {
                if (diff < answer) {
                    answer = diff;
                }
                index1++;
            }
            if (diff < M) {
                index2++;
            }
        }

        System.out.println(answer);
    }
}