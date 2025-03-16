package src.problem.baekjoon.class03_gold;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class N12851_숨바꼭질_2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int K = scanner.nextInt();

        int[] dp = new int[100001];
        int[] caseCount = new int[100001];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[N] = 0;
        caseCount[N]++;

        Queue<Integer> queue = new LinkedList<>();
        queue.add(N);
        while (!queue.isEmpty()) {
            int now = queue.poll();
            int[] nextList = {now - 1, now + 1, now * 2};
            for (int next : nextList) {
                if (next >= 0 && next < dp.length) {
                    if (dp[next] == Integer.MAX_VALUE) {
                        dp[next] = dp[now] + 1;
                        caseCount[next]++;
                        queue.add(next);
                    }
                    else if (dp[next] == dp[now] + 1) {
                        caseCount[next]++;
                        queue.add(next);
                    }
                }
            }
        }
        System.out.println(dp[K]);
        System.out.println(caseCount[K]);
    }
}