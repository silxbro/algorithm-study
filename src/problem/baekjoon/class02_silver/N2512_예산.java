package src.problem.baekjoon.class02_silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class N2512_예산 {
    static int[] budgets;
    static int M;
    static long answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        budgets = new int[N];
        int max = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            budgets[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, budgets[i]);
        }

        M = Integer.parseInt(br.readLine());

        binarySearch(1, max);

        System.out.println(answer);
    }

    private static void binarySearch(int s, int e) {
        if (s <= e) {
            int m = (s + e) / 2;
            long sum = 0;
            for (int i = 0; i < budgets.length; i++) {
                sum += Math.min(m, budgets[i]);
            }
            if (sum <= M) {
                answer = m;
                binarySearch(m + 1, e);
            } else {
                binarySearch(s, m - 1);
            }
        }
    }
}