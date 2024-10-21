package src.problem.baekjoon.level26_분할_정복;

import java.util.Scanner;

class N11444_피보나치_수_6 {

    final static long DEL = 1000000007;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();

        System.out.println(dc(n, 0 , 1));
    }

    private static long dc(long n, long first, long second) {
//        if (n == 2) {
//            return (first + second) % DEL;
//        }
        return 0;
    }
}