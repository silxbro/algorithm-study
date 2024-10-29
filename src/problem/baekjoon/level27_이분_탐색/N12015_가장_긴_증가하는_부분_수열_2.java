package src.problem.baekjoon.level27_이분_탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class N12015_가장_긴_증가하는_부분_수열_2 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        int index = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr[0] = Integer.parseInt(st.nextToken());

        for (int i = 1; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (num > arr[index]) {
                arr[++index] = num;
            } else {
                arr[getPosition(arr, index, num)] = num;
            }
        }

        System.out.println(index + 1);
    }

    private static int getPosition(int[] arr, int end, int num) {
        int s = 0;
        int e = end;
        int position = -1;
        while (s <= e) {
            int m = (s + e) / 2;
            if (arr[m] >= num) {
                position = m;
                e = m - 1;
            } else {
                s = m + 1;
            }
        }
        return position;
    }
}