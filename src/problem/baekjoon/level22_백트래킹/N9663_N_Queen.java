package src.problem.baekjoon.level22_백트래킹;

import java.util.Scanner;

class N9663_N_Queen {
    static int count = 0;
    static int N;
    static int[] position;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        position = new int[N + 1];

        backtrack(1);

        System.out.println(count);
    }

    private static void backtrack(int row) {
        if (row > N) {
            count++;
            return;
        }
        for (int i = 1; i <= N; i++) {
            if (canAdd(row, i)) {
                position[row] = i;
                backtrack(row + 1);
            }
        }
    }

    private static boolean canAdd(int row, int target) {
        for (int r = 1; r < row; r++) {
            if (canAttack(r, position[r], row, target)) {
                return false;
            }
        }
        return true;
    }

    public static boolean canAttack(int row1, int position1, int row2, int position2) {
        if (position1 == position2) {
            return true;
        }
        return Math.abs(row1 - row2) == Math.abs(position1 - position2);
    }
}