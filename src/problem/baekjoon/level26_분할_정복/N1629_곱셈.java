package src.problem.baekjoon.level26_분할_정복;

import java.util.Scanner;

class N1629_곱셈 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long A = scanner.nextLong();
        long B = scanner.nextLong();
        long C = scanner.nextLong();

        System.out.println(dc(A, B, C));
    }

    private static long dc(long a, long b, long c) {
        if (a == c || c == 1) {
            return 0;
        }
        if (b == 1) {
            return a % c;
        }
        long divided = dc(a, b / 2, c);
        if (b % 2 != 0) {
            return (dc(a, 1, c) * ((divided * divided) % c)) % c;   // long 범위 또한 벗어날 수 있음을 주의
        }
        return (divided * divided) % c;
    }
}