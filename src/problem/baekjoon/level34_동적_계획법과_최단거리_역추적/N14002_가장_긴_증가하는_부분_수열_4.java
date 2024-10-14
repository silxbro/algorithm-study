package src.problem.baekjoon.level34_동적_계획법과_최단거리_역추적;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class N14002_가장_긴_증가하는_부분_수열_4 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        int[] dp = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
            dp[i] = 1;
        }

        int maxPosition = 0;
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if (A[i] > A[j] && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                    if (dp[i] > dp[maxPosition]) {
                        maxPosition = i;
                    }
                }
            }
        }

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.add(A[maxPosition]);
        int position = maxPosition;
        for (int i = position - 1; i >= 0; i--) {
            if (A[i] < A[position] && dp[i] == dp[position] - 1) {
                queue.add(A[i]);
                position = i;
            }
        }
        StringBuilder stb = new StringBuilder();
        stb.append(queue.size()).append("\n");
        while (!queue.isEmpty()) {
            stb.append(queue.poll()).append(" ");
        }

        System.out.println(stb);
    }
}