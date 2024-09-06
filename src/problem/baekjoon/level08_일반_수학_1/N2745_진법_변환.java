package src.problem.baekjoon.level08_일반_수학_1;

import java.util.Scanner;

class N2745_진법_변환 {

    static String digit = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String N = scanner.next();
        int B = scanner.nextInt();
        long answer = 0;
        long mul = (long) Math.pow(B, N.length() - 1);

        for (int i = 0; i < N.length(); i++) {
            answer += digit.indexOf(N.charAt(i)) * mul;
            mul /= B;
        }

        System.out.println(answer);
    }
}