package src.problem.baekjoon.level08_일반_수학_1;

import java.util.Scanner;

class N2292_벌집 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long N = scanner.nextLong();

        long count = 1;
        long number = 1;
        while (number < N) {
            count++;
            number += 6 * (count - 1);
        }
        System.out.println(count);
    }
}