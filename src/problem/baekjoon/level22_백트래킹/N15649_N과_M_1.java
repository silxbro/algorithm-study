package src.problem.baekjoon.level22_백트래킹;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class N15649_N과_M_1 {

    static List<List<Integer>> result;
    static int N, M;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        result = new ArrayList<>();
        N = scanner.nextInt();
        M = scanner.nextInt();

        backtrack(new ArrayList<>());
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

    private static void backtrack(List<Integer> numbers) {
        if (numbers.size() == M) {
            result.add(numbers);
            return;
        }
        for (int i = 1; i <= N; i++) {
            if (!numbers.contains(i)) {
                List<Integer> list = new ArrayList<>(numbers);  // 선언 위치 중요
                list.add(i);
                backtrack(list);
            }
        }
    }
}