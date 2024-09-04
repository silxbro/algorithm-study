package src.problem.baekjoon.level05_문자열;

import java.util.Arrays;
import java.util.Scanner;

class N10809_알파벳_찾기 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] location = new int[26];
        Arrays.fill(location, -1);
        String target = scanner.next();
        for (int i = 0; i < target.length(); i++) {
            int number = target.charAt(i) - 'a';
            if (location[number] == -1) {
                location[number] = i;
            }
        }

        for (int i = 0; i < location.length; i++) {
            System.out.print(location[i] + " ");
        }
    }

}