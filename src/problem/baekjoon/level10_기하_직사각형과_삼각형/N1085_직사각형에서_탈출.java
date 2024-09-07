package src.problem.baekjoon.level10_기하_직사각형과_삼각형;

import java.util.Scanner;

class N1085_직사각형에서_탈출 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        int w = scanner.nextInt();
        int h = scanner.nextInt();

        int min = Math.min(h - y,Math.min(w - x, Math.min(x,y)));
        System.out.println(min);
    }
}