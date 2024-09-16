package src.problem.baekjoon.level21_재귀;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class N25501_재귀의_귀재 {

    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder stb = new StringBuilder();

        for (int t = 0; t < T; t++) {
            String str = br.readLine();
            count = 0;
            int isPalindrome = recursion(str, 0, str.length() - 1);
            stb.append(isPalindrome).append(" ").append(count).append("\n");
        }
        System.out.println(stb);
    }

    private static int recursion(String str, int l, int r) {
        count++;
        if (l >= r) {
            return 1;
        }
        if (str.charAt(l) != str.charAt(r)) {
            return 0;
        }
        return recursion(str, l + 1, r - 1);
    }
}