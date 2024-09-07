package src.problem.baekjoon.level10_기하_직사각형과_삼각형;

import java.util.Scanner;

class N3009_네_번째_점 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x = 0;
        int y = 0;
        int x1 = scanner.nextInt();
        int y1 = scanner.nextInt();
        int x2 = scanner.nextInt();
        int y2 = scanner.nextInt();
        int x3 = scanner.nextInt();
        int y3 = scanner.nextInt();

        if (x1 == x2) {
            x = x3;
        } else if (x1 == x3) {
            x = x2;
        } else {
            x = x1;
        }

        if (y1 == y2) {
            y = y3;
        } else if (y1 == y3) {
            y = y2;
        } else {
            y = y1;
        }
        System.out.print( x + " " + y);
    }
}