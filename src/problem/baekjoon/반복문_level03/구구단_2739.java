package src.problem.baekjoon.반복문_level03;

import java.util.Scanner;

class 구구단_2739 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int target = scanner.nextInt();

        for (int num = 1; num <= 9; num++) {
            System.out.println(target + " * " + num + " = " + target * num);
        }
    }

}