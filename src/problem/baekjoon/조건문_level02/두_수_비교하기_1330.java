package src.problem.baekjoon.조건문_level02;

import java.util.Scanner;

class 두_수_비교하기_1330 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int A = scanner.nextInt();
        int B = scanner.nextInt();

        if (A > B) {
            System.out.println(">");
        }
        else if (A < B) {
            System.out.println("<");
        }
        else {
            System.out.println("==");
        }
    }

}