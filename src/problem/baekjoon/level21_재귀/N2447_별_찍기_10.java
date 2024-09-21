package src.problem.baekjoon.level21_재귀;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

class N2447_별_찍기_10 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int k = 0;
        while (N >= 3) {
            k++;
            N /= 3;
        }

        System.out.println(starPattern(k));
    }

    private static String starPattern(int k) {
        if (k == 0) {
            return "*";
        }
        String external = external(k);
        String internal = internal(k);
        return external + "\n" + internal + "\n" + external;
    }

    private static String external(int k) {
        return Arrays.stream(starPattern(k - 1).split("\n"))
            .map(string -> string.repeat(3)).collect(Collectors.joining("\n"));
    }

    private static String internal(int k) {
        return Arrays.stream(starPattern(k - 1).split("\n"))
            .map(string -> string + " ".repeat((int)Math.pow(3, k - 1)) + string).collect(Collectors.joining("\n"));
    }
}
