package src.problem.baekjoon.level23_동적_계획법_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

class N2565_전깃줄 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());

        int[][] link = new int[n + 1][2];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            link[i][0] = Integer.parseInt(st.nextToken());
            link[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(link, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        int[] dp = new int[n + 1];
        int maxLength = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            int now = link[i][1];
            for (int j = i - 1; j >= 0; j--) {
                if (link[j][1] < now) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxLength = Math.max(maxLength, dp[i]);
        }
        System.out.println(n - maxLength);
    }
}