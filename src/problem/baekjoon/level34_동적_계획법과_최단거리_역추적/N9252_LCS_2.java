package src.problem.baekjoon.level34_동적_계획법과_최단거리_역추적;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class N9252_LCS_2 {

    static String str1, str2;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        str1 = br.readLine();
        str2 = br.readLine();

        dp = new int[str1.length() + 1][str2.length() + 1];
        for (int i = 1; i <= str1.length(); i++) {
            for (int j = 1; j <= str2.length(); j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        int maxLen = dp[str1.length()][str2.length()];
        System.out.println(maxLen);
        if (maxLen == 0) {
            return;
        }
        System.out.println(getMaxStr(str1.length(), str2.length()));
    }

    private static String getMaxStr(int index1, int index2) {
        if (index1 < 1 || index2 < 1) {
            return "";
        }
        if (str1.charAt(index1 - 1) == str2.charAt(index2 - 1)) {
            return getMaxStr(index1 - 1, index2 - 1) + str1.charAt(index1 - 1);
        }
        if (dp[index1 - 1][index2] >= dp[index1][index2 - 1]) {
            return getMaxStr(index1 - 1, index2);
        }
        return getMaxStr(index1, index2 - 1);
    }
}