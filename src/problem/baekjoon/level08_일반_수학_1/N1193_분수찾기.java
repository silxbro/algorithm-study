package src.problem.baekjoon.level08_일반_수학_1;

import java.util.Scanner;

class N1193_분수찾기 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int X = scanner.nextInt();
        int num = 1;
        int son = 0;
        int mother = 0;

        while(true) {
            if (num * (num + 1) >= X * 2) {
                if (num % 2 == 0) {
                    son = X - num * (num - 1) / 2;
                    mother = num + 1 - son;
                } else {
                    mother = X - num * (num - 1) / 2;
                    son = num + 1 - mother;
                }
                break;
            }
            num++;
        }
        System.out.println(son + "/" + mother);
    }
}