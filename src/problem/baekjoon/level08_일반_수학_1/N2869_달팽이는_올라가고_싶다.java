package src.problem.baekjoon.level08_일반_수학_1;

import java.util.Scanner;

class N2869_달팽이는_올라가고_싶다 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int A = scanner.nextInt();
        int B = scanner.nextInt();
        int V = scanner.nextInt();

        // N일 걸린다고 가정할 때, A * N - B * (N - 1) >= V 식을 만족
        // N >= (V - B) / (A - B)
        int temp = (V - B) / (A - B);
        if ((V - B) % (A - B) != 0) {
            temp++;
        }
        System.out.println(temp);
    }
}