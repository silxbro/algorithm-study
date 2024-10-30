package src.problem.baekjoon.class02_silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;

class N4659_비밀번호_발음하기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stb = new StringBuilder();
        while (true) {
            String str = br.readLine();
            if (str.equals("end")) {
                break;
            }

            stb.append(String.format("<%s> ", str))
                .append(isAcceptable(str) ? "is acceptable." : "is not acceptable.").append("\n");
        }

        System.out.println(stb);
    }

    private static boolean isAcceptable(String str) {
        Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u');
        boolean vowel = false;
        int seqCount = 1;
        for (int i = 0; i < str.length(); i++) {
            char now = str.charAt(i);
            if (vowels.contains(now)) {
                vowel = true;
            }
            if (i > 0) {
                if (vowels.contains(now) && !vowels.contains(str.charAt(i - 1))
                    || !vowels.contains(now) && vowels.contains(str.charAt(i - 1))) {
                    seqCount = 1;
                } else {
                    seqCount++;
                    if (seqCount == 3) {
                        return false;
                    }
                }
                if (now == str.charAt(i - 1) && now != 'e' && now != 'o') {
                    return false;
                }
            }
        }
        return vowel;
    }
}