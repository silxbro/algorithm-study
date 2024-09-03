package src.problem.baekjoon.level03_반복문;

import java.util.Scanner;

class N2739_구구단 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int target = scanner.nextInt();

        for (int num = 1; num <= 9; num++) {
            System.out.println(target + " * " + num + " = " + target * num);
        }
    }

}