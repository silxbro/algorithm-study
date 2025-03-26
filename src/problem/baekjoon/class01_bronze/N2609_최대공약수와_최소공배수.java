package src.problem.baekjoon.class01_bronze;

import java.util.Scanner;

public class N2609_최대공약수와_최소공배수 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();

        int gcd = getGCD(a, b);
        int lcm = (a * b) / gcd;

        System.out.println(gcd);
        System.out.println(lcm);
    }

    private static int getGCD(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}