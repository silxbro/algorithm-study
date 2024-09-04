package src.problem.baekjoon.level05_문자열;

import java.util.Scanner;

class N9086_문자열 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int t = 0; t < T; t++) {
            String str = scanner.next();
            String reversed = new StringBuilder(str).reverse().toString();
            StringBuilder stb = new StringBuilder();
            stb.append(str.charAt(0));
            stb.append(reversed.charAt(0));
            System.out.println(stb);
        }
    }
}