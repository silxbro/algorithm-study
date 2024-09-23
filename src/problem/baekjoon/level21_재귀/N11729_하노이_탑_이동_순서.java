package src.problem.baekjoon.level21_재귀;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

class N11729_하노이_탑_이동_순서 {

    static Stack[] stacks;
    static List<int[]> result;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        result = new ArrayList<>();
        stacks = new Stack[3];
        for (int i = 0; i < 3; i++) {
            stacks[i] = new Stack<>();
        }

        for (int i = N; i >= 1; i--) {
            stacks[0].push(i);
        }
        solveHanoi(N, 0, 1, 2);

        StringBuilder stb = new StringBuilder();
        stb.append(result.size()).append("\n");
        for (int[] move : result) {
            stb.append(move[0]).append(" ").append(move[1]).append("\n");
        }
        System.out.println(stb);
    }

    private static void solveHanoi(int n, int from, int middle, int to) {
        if (n == 1) {
            moveHanoi(from, to);
            result.add(new int[]{from + 1, to + 1});
            return;
        }
        solveHanoi(n - 1, from, to, middle);
        solveHanoi(1, from, middle, to);
        solveHanoi(n - 1, middle, from, to);
    }

    private static void moveHanoi(int from, int to) {
        stacks[to].push(stacks[from].pop());
    }
}