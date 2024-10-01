package src.problem.baekjoon.level23_동적_계획법_1;

import java.util.Scanner;

class N9251_LCS {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str1 = scanner.nextLine();
        String str2 = scanner.nextLine();

        // 처음에 생각한 풀이 : dp[i - 1][j - 1], dp[i - 1][j], dp[i][j - 1] 중 최댓값을 우선 저장한 후, i와 j의 문자가 동일하면 1 증가
        // ---> 틀린 방법 : 왜 틀린지 모르겠음
        // 고친 풀이 : i와 j의 문자가 동일하면 dp[i - 1][j - 1] + 1, 다르면 dp[i - 1][j], dp[i][j - 1] 중 최댓값
        int[][] dp = new int[str1.length() + 1][str2.length() + 1];
        for (int i = 1; i <= str1.length(); i++) {
            for (int j = 1; j <= str2.length(); j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
            }
        }

        System.out.println(dp[str1.length()][str2.length()]);
    }
}