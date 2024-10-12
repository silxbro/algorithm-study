package src.problem.baekjoon.level29_동적_계획법_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class N11049_행렬_곱셈_순서 {

    static int[][] matrixInfo;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        matrixInfo = new int[N + 1][2];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            matrixInfo[i][0] = Integer.parseInt(st.nextToken());
            matrixInfo[i][1] = Integer.parseInt(st.nextToken());
        }

        dp = new int[N + 1][N + 1];
        System.out.println(recurse(1, N));
    }

    private static int recurse(int start, int end) {
        if (dp[start][end] > 0) {
            return dp[start][end];
        }
        if (start == end) {
            return 0;
        }

        dp[start][end] = Integer.MAX_VALUE;
        for (int i = 0; i < end - start; i++) {
            int middle = start + i;
            dp[start][end] = Math.min(dp[start][end]
                , recurse(start, middle) + recurse(middle + 1, end) + (matrixInfo[start][0] * matrixInfo[middle][1] * matrixInfo[end][1]));
        }
        return dp[start][end];
    }
}