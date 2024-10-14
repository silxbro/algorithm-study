package src.problem.baekjoon.level34_동적_계획법과_최단거리_역추적;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

class N13913_숨바꼭질_4 {
    static int N, K;
    static int[] dp;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        K = scanner.nextInt();

        dp = new int[100001];
        bfs();

        StringBuilder stb = new StringBuilder();
        stb.append(dp[K] - 1).append("\n");

        Stack<Integer> stack = new Stack<>();
        int index = K;
        while (index >= 0 && index < dp.length) {
            stack.push(index);
            if (index == N) {
                break;
            }
            if (index % 2 == 0 && dp[index] == dp[index / 2] + 1) {
                index /= 2;
            } else if (index < dp.length && dp[index] == dp[index + 1] + 1) {
                index++;
            } else if (index > 0 && dp[index] == dp[index - 1] + 1) {
                index--;
            }
        }

        while (!stack.isEmpty()) {
            stb.append(stack.pop()).append(" ");
        }
        System.out.println(stb);
    }

    private static void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        dp[N] = 1;
        queue.add(N);

        while(!queue.isEmpty()) {
            int now = queue.poll();
            if (now == K) {
                break;
            }
            int[] numbers = {now - 1, now + 1, now * 2};
            for (int next : numbers) {
                if (next >= 0 && next < dp.length && dp[next] == 0) {
                    dp[next] = dp[now] + 1;
                    queue.add(next);
                }
            }
        }
    }
}