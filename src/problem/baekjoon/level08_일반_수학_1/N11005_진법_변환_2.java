package src.problem.baekjoon.level08_일반_수학_1;

import java.util.Scanner;

class N11005_진법_변환_2 {

    static String digit = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        long N = scanner.nextLong();
        int B = scanner.nextInt();

        StringBuilder stb = new StringBuilder();

        while (N > 0) {
            stb.append(digit.charAt((int)(N % B)));
            N /= B;
        }

        System.out.println(stb.reverse());
    }
}