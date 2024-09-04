package src.problem.baekjoon.level05_문자열;

import java.util.Arrays;
import java.util.Scanner;

class N1152_단어의_개수 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String sentence = scanner.nextLine();

        long count = Arrays.stream(sentence.split(" "))
            .filter(str -> !str.isEmpty())
            .count();

        System.out.println(count);
    }

}