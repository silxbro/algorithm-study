package src.problem.baekjoon.class02_silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class N3758_KCPC {

    static int[] finalScores;
    static int[] count;
    static int[] lastTime;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        StringBuilder stb = new StringBuilder();
        int[][] scores;

        for (int c = 0; c < T; c++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            scores = new int[n + 1][k + 1];
            count = new int[n + 1];
            lastTime = new int[n + 1];

            for (int a = 0; a < m; a++) {
                st = new StringTokenizer(br.readLine());
                int i = Integer.parseInt(st.nextToken());
                int j = Integer.parseInt(st.nextToken());
                int s = Integer.parseInt(st.nextToken());
                scores[i][j] = Math.max(scores[i][j], s);
                count[i]++;
                lastTime[i] = a;
            }

            finalScores = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= k; j++) {
                    finalScores[i] += scores[i][j];
                }
            }

            int count = 0;
            for (int i = 1; i <= n; i++) {
                if (i != t) {
                    if (higherRank(i, t)) {
                        count++;
                    }
                }
            }
            stb.append(count + 1).append("\n");
        }
        System.out.println(stb);
    }

    private static boolean higherRank(int target, int me) {
        if (finalScores[target] == finalScores[me] && count[target] == count[me]) {
            return lastTime[target] < lastTime[me];
        }
        if (finalScores[target] == finalScores[me]) {
            return count[target] < count[me];
        }
        return finalScores[target] > finalScores[me];
    }
}