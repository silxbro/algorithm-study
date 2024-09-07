package src.problem.baekjoon.level09_약수_배수와_소수;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

class N2501_약수_구하기 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int K = scanner.nextInt();

        Set<Integer> divisors = new TreeSet<>();

        for (int i = 1; i * i <= N; i++) {
            if (N % i == 0) {
                divisors.add(i);
                divisors.add(N / i);
            }
        }
        if (K > divisors.size()) {
            System.out.println(0);
            return;
        }
        System.out.println(divisors.stream().collect(Collectors.toUnmodifiableList()).get(K - 1));
    }
}