package src.problem.baekjoon.level06_심화_1;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class N1157_단어_공부 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next().toUpperCase();

        Map<Character, Integer> map = new HashMap<>();
        Character result = null;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < str.length(); i++) {
            Character c = str.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
            if (map.get(c) > max) {
                result = c;
                max = map.get(c);
                continue;
            }
            if (map.get(c) == max) {
                result = '?';
            }
        }

        System.out.println(result);
    }
}