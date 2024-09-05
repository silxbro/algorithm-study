package src.problem.baekjoon.level06_심화_1;

import java.util.Scanner;

class N10988_팰린드롬인지_확인하기 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();

        int start = 0;
        int end = str.length() - 1;
        boolean isPalindrome = true;

        while (start < end) {
            if (str.charAt(start) != str.charAt(end)) {
                isPalindrome = false;
                break;
            }
            start++;
            end--;
        }

        if (isPalindrome) {
            System.out.println("1");
            return;
        }
        System.out.println("0");
    }
}