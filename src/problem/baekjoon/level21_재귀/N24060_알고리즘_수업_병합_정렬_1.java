package src.problem.baekjoon.level21_재귀;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class N24060_알고리즘_수업_병합_정렬_1 {

    static int count;
    static int answer;
    static int[] A;
    static int N, K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        A = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        answer = -1;
        merge_sort(0, N - 1);
        System.out.println(answer);
    }

    private static void merge_sort(int s, int e) {
        if (s < e) {
            int m = (s + e) / 2;
            merge_sort(s, m);
            merge_sort(m + 1, e);
            merge(s, m, e);
        }
    }

    private static void merge(int s, int m, int e) {
        int i = s;
        int j = m + 1;
        int k = 0;
        int[] temp = new int[e - s + 1];
        while (i <= m && j <= e) {
            if (A[i] <= A[j]) {
                temp[k++] = A[i++];
            } else {
                temp[k++] = A[j++];
            }
        }
        while (i <= m) {
            temp[k++] = A[i++];
        }
        while (j <= e) {
            temp[k++] = A[j++];
        }

        for (int n = 0; n < temp.length; n++) {
            A[s + n] = temp[n];
            count++;
            if (count == K) {
                answer = A[s + n];
                return;
            }
        }
    }
}