package src.problem.baekjoon.level04_1차원_배열;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

class N3052_나머지 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set<Integer> remains = new HashSet<>();

        for (int i = 0; i < 10; i++) {
            remains.add(scanner.nextInt() % 42);
        }

        System.out.println(remains.size());
    }

}