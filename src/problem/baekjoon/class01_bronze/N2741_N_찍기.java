package src.problem.baekjoon.class01_bronze;

import java.util.Scanner;

class N2741_N_찍기 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();

        StringBuilder stb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            stb.append(i).append("\n");
        }

        System.out.println(stb);
    }
}