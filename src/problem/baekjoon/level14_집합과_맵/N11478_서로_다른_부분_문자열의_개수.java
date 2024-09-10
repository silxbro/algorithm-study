package src.problem.baekjoon.level14_집합과_맵;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

class N11478_서로_다른_부분_문자열의_개수 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();

        Set<String> partials = new HashSet<>();
        for (int len = 1; len <= str.length(); len++) {
            for (int pos = 0; pos <= str.length() - len; pos++) {
                partials.add(str.substring(pos, pos + len));
            }
        }

        System.out.println(partials.size());
    }
}