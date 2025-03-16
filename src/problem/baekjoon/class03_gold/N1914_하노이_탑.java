package src.problem.baekjoon.class03_gold;

import java.math.BigInteger;
import java.util.Scanner;

public class N1914_하노이_탑 {
    static StringBuilder stb;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();

        BigInteger count = new BigInteger("2");
        System.out.println(count.pow(N).subtract(new BigInteger("1")));
        if (N > 20) {
            return;
        }

        stb = new StringBuilder();
        hanoi(N, 1, 3);

        System.out.println(stb);
    }

    private static void hanoi(int n, int start, int end) {
        if (n == 1) {
            stb.append(start).append(" ").append(end).append("\n");
            return;
        }
        int middle = 6 - start - end;
        hanoi(n - 1, start, middle);
        hanoi(1, start, end);
        hanoi(n - 1, middle, end);
    }
}