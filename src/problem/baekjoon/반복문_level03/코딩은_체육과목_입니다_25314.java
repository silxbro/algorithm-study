package src.problem.baekjoon.반복문_level03;

import java.util.Scanner;

class 코딩은_체육과목_입니다_25314 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int repeat = scanner.nextInt() / 4;

        for (int count = 0; count < repeat; count++) {
            System.out.print("long ");
        }
        System.out.print("int");
    }

}