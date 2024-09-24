package src.problem.baekjoon.level22_백트래킹;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class N9663_N_Queen {
    static int count = 0;
    static int N;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();

        for (int i = 1; i <= N; i++) {
            backtrack(1, new ArrayList<>());
        }


        System.out.println(count);
    }

    private static void backtrack(int row, List<int[]> points) {
        if (row > N) {
            count++;
            return;
        }
        for (int i = 1; i <= N; i++) {
            int[] now = new int[]{row, i};
            if (canAdd(now, points)) {
                List<int[]> added = new ArrayList<>(points);
                added.add(now);
                backtrack(row + 1, added);
            }
        }
    }

    private static boolean canAdd(int[] now, List<int[]> points) {
        if (points.isEmpty()) {
            return true;
        }
        for (int[] point : points) {
            if (canAttack(now, point)) {
                return false;
            }
        }
        return true;
    }

    public static boolean canAttack(int[] point1, int[] point2) {
        if (point1[1] == point2[1]) {
            return true;
        }
        int rowDiff = point1[0] - point2[0];
        int colDiff = point1[1] - point2[1];
        return Math.abs(rowDiff) == Math.abs(colDiff);
    }
}