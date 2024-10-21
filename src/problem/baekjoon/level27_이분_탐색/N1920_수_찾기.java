package src.problem.baekjoon.level27_이분_탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class N1920_수_찾기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(A);

        StringBuilder stb = new StringBuilder();
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int num = Integer.parseInt(st.nextToken());
            stb.append(search(A, num, 0, N - 1) ? 1 : 0).append("\n");
        }
        System.out.println(stb);
    }

    private static boolean search(int[] arr, int target, int s, int e) {
        if (s <= e) {
            int m = (s + e) / 2;
            int middle = arr[m];
            if (target < middle) {
                return search(arr, target, s, m - 1);
            }
            if (target > middle) {
                return search(arr, target, m + 1, e);
            }
            return true;
        }
        return false;
    }
}