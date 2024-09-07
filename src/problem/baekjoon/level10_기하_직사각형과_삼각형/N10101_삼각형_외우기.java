package src.problem.baekjoon.level10_기하_직사각형과_삼각형;

import java.util.Scanner;

class N10101_삼각형_외우기 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();

        if (a + b + c != 180) {
            System.out.println("Error");
            return;
        }
        if (a == b && b == c) {
            System.out.println("Equilateral");
            return;
        }
        if (a == b || b == c || a == c) {
            System.out.println("Isosceles");
            return;
        }
        System.out.println("Scalene");
    }
}