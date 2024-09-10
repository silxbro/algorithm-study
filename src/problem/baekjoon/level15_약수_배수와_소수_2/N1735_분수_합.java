package src.problem.baekjoon.level15_약수_배수와_소수_2;

import java.util.Scanner;

class N1735_분수_합 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int moleculeA = scanner.nextInt();
        int denominatorA = scanner.nextInt();
        int moleculeB = scanner.nextInt();
        int denominatorB = scanner.nextInt();

        //두 분모의 최대공약수를 구한 후, 각 분자에 (최소공배수 / 분모)의 값을 곱하여 통분한다.
        int gcd = gcd(denominatorA, denominatorB);
        int molecule = (moleculeA * denominatorB + moleculeB * denominatorA) / gcd;
        int denominator = denominatorA * denominatorB / gcd;

        //분수 합의 분자, 분모의 최대공약수를 구한 후, 약분한다.
        gcd = gcd(molecule, denominator);

        System.out.println(molecule / gcd + " " + denominator / gcd);
    }

    private static int gcd(int numberA, int numberB) {
        if (numberB == 0) {
            return numberA;
        }
        return gcd(numberB, numberA % numberB);
    }
}