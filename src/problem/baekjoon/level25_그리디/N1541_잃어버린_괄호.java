package src.problem.baekjoon.level25_그리디;

import java.util.Arrays;
import java.util.Scanner;

class N1541_잃어버린_괄호 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();

        String[] minusSplit = line.split("-");

        long answer = getSum(minusSplit[0]);
        for (int i = 1; i < minusSplit.length; i++) {
            answer -= getSum(minusSplit[i]);
        }
        System.out.println(answer);
    }

    private static long getSum(String formula) {
        return Arrays.stream(formula.split("[+]"))
            .mapToLong(Long::parseLong)
            .sum();
    }
}