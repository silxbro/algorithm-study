package src.problem.baekjoon.level05_문자열;

import java.util.Scanner;

class N5622_다이얼 {

    public static void main(String[] args) {
        String number = "22233344455566677778889999";
        String word = new Scanner(System.in).next();

        int time = 0;
        for (int i = 0; i < word.length(); i++) {
            time += number.charAt(word.charAt(i) - 'A') - '0' + 1;
        }
        System.out.println(time);
    }
}