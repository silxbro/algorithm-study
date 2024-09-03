package src.problem.baekjoon.level02_조건문;

import java.util.Scanner;

class N1330_두_수_비교하기 {

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