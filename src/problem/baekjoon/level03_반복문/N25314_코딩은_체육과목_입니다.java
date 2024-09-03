package src.problem.baekjoon.level03_반복문;

import java.util.Scanner;

class N25314_코딩은_체육과목_입니다 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int repeat = scanner.nextInt() / 4;

        for (int count = 0; count < repeat; count++) {
            System.out.print("long ");
        }
        System.out.print("int");
    }

}