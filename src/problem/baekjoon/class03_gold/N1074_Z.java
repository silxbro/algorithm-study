package src.problem.baekjoon.class03_gold;

import java.util.Scanner;

public class N1074_Z {

    static long row, col;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        row = scanner.nextLong();
        col = scanner.nextLong();
        System.out.println(getOrder(0, 0, (long) Math.pow(2, N)));
    }

    private static long getOrder(long sRow, long sCol, long len) {
        if (len == 1) {
            return 0;
        }
        long half = len / 2;
        long loaf = (long) Math.pow(half, 2);
        if (row < sRow + half && col < sCol + half) {
            return getOrder(sRow, sCol, len / 2);
        }
        if (row < sRow + half && col >= sCol + half) {
            return loaf + getOrder(sRow, sCol + half, half);
        }
        if (row >= sRow + half && col < sCol + half) {
            return loaf * 2 + getOrder(sRow + half, sCol, half);
        }
        return loaf * 3 + getOrder(sRow + half, sCol + half, half);
    }
}