package src.problem.baekjoon.level22_백트래킹;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class N15650_N과_M_2 {

    static List<List<Integer>> result;
    static int N, M;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        M = scanner.nextInt();
        result = new ArrayList<>();

        backtrack(0, new ArrayList<>());

        StringBuilder stb = new StringBuilder();
        for (int i = 0; i < result.size(); i++) {
            List<Integer> numbers = result.get(i);
            for (int number : numbers) {
                stb.append(number).append(" ");
            }
            stb.append("\n");
        }

        System.out.println(stb);
    }

    private static void backtrack(int number, List<Integer> numbers) {
        if (numbers.size() == M) {
            result.add(numbers);
            return;
        }
        for (int i = number + 1; i <= N; i++) {
            List<Integer> list = new ArrayList<>(numbers);
            list.add(i);
            backtrack(i, list);
        }
    }
}