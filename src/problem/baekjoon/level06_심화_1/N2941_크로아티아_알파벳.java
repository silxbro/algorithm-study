package src.problem.baekjoon.level06_심화_1;

import java.util.Scanner;

class N2941_크로아티아_알파벳 {

    public static void main(String[] args) {
        String[] words = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();

        for (String croatia : words) {
            str = str.replaceAll(croatia, "a");
        }

        System.out.println(str.length());
    }

}