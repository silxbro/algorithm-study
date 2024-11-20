package src.problem.baekjoon.level29_동적_계획법_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class N7579_앱 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] memory = new int[N];
        int[] cost = new int[N];

        st = new StringTokenizer(br.readLine());
        int totalMemory = 0;
        for (int i = 0; i < N; i++) {
            memory[i] = Integer.parseInt(st.nextToken());
            totalMemory += memory[i];
        }

        st = new StringTokenizer(br.readLine());
        int totalCost = 0;
        for (int i = 0; i < N; i++) {
            cost[i] = Integer.parseInt(st.nextToken());
            totalCost += cost[i];
        }

        int[] dp = new int[totalMemory + 1];
        for (int i = 0; i < N; i++) {
            for (int j = totalMemory; j >= memory[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - memory[i]] + cost[i]);
            }
        }

        System.out.println(totalCost - dp[totalMemory - M]);
    }
}