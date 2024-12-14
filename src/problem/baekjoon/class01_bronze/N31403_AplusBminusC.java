package src.problem.baekjoon.class01_bronze;

import java.util.Scanner;

class N31403_AplusBminusC {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int A = scanner.nextInt();
        int B = scanner.nextInt();
        int C = scanner.nextInt();

        int result1 = A + B - C;
        StringBuilder stb = new StringBuilder();
        int result2 = Integer.parseInt(stb.append(A).append(B).toString()) - C;

        System.out.println(result1);
        System.out.println(result2);
    }
}