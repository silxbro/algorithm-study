package src.problem.baekjoon.class03_gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class N1759_암호_만들기 {

    static int L, C;
    static char[] chars;
    static List<String> result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        chars = new char[C];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < C; i++) {
            chars[i] = st.nextToken().charAt(0);
        }
        Arrays.sort(chars);

        result = new ArrayList<>();
        backtrack(0, new StringBuilder(), 0);

        Collections.sort(result);

        System.out.println(String.join("\n", result));
    }

    private static void backtrack(int num, StringBuilder password, int vowelCount) {
        if (password.length() == L && vowelCount >= 1 && L - vowelCount >= 2) {
            result.add(password.toString());
            return;
        }
        if (num == C) {
            return;
        }
        backtrack(num + 1, password.append(chars[num]), vowelCount + (isVowel(chars[num]) ? 1 : 0));
        password.deleteCharAt(password.length() - 1);
        backtrack(num + 1, password, vowelCount);
    }

    private static boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}