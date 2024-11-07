package src.problem.baekjoon.class03_gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

class N12919_A와_B_2 {

    static boolean answer = false;
    static Set<String> set = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str1 = br.readLine();
        String str2 = br.readLine();

        backtrack(str2, str1);

        System.out.println(answer ? 1 : 0);
    }

    private static void backtrack(String str, String original) {
        if (str.length() == original.length()) {
            if (str.equals(original)) {
                answer = true;
            }
            return;
        }

        if (str.endsWith("A")) {
            backtrack(str.substring(0, str.length() - 1), original);
        }
        if (str.startsWith("B")) {
            String reversed = new StringBuilder(str).reverse().toString();
            backtrack(reversed.substring(0, reversed.length() - 1), original);
        }
    }
}