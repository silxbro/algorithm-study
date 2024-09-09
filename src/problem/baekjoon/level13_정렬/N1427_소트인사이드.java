package src.problem.baekjoon.level13_정렬;

import java.util.Scanner;

class N1427_소트인사이드 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String N = scanner.next();
        int[] count = new int[10];
        for (int i = 0; i < N.length(); i++) {
            count[N.charAt(i) - '0']++;
        }

        StringBuilder stb = new StringBuilder();
        for (int i = 9; i >= 0; i--) {
            if (count[i] > 0) {
                stb.append(String.valueOf(i).repeat(count[i]));
            }
        }
        System.out.println(stb);
    }
}