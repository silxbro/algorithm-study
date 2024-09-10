package src.problem.baekjoon.level15_약수_배수와_소수_2;

import java.util.Scanner;

class N13241_최소공배수 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long a = scanner.nextLong();
        long b = scanner.nextLong();
        System.out.println(a * b / gcd(a, b));
    }

    private static long gcd(long a, long b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}