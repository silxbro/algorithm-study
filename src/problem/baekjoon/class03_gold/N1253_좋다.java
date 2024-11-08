package src.problem.baekjoon.class03_gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class N1253_좋다 {

    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int count = 0;
        for (int i = 0; i < N; i++) {
            if (isGood(i)) {
                count++;
            }
        }
        System.out.println(count);
    }

    private static boolean isGood(int index) {
        int target = arr[index];
        int s = 0;
        int e = arr.length - 1;
        while (s < e) {
            int sum = arr[s] + arr[e];
            if (sum == target) {
                if (s != index && e != index) {
                    return true;
                }
                if (s == index) {
                    s++;
                } else {
                    e--;
                }
            } else if (sum < target) {
                s++;
            } else {
                e--;
            }
        }
        return false;
    }
}