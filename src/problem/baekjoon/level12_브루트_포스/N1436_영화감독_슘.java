package src.problem.baekjoon.level12_브루트_포스;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

class N1436_영화감독_슘 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        String threeSix = "666";

        Set<Integer> numbers = new TreeSet<>();
        for (int a = 0; a < 10; a++) {
            for (int b = 0; b < 10; b++) {
                for (int c = 0; c < 10; c++) {
                    for (int d = 0; d < 10; d++) {
                        numbers.add(Integer.parseInt("" + threeSix + a + b + c + d));
                        numbers.add(Integer.parseInt("" + a + threeSix + b + c + d));
                        numbers.add(Integer.parseInt("" + a + b + threeSix + c + d));
                        numbers.add(Integer.parseInt("" + a + b + c + threeSix + d));
                        numbers.add(Integer.parseInt("" + a + b + c + d + threeSix));
                    }
                }
            }
        }

        System.out.println(numbers.stream().collect(Collectors.toUnmodifiableList()).get(N - 1));
    }
}