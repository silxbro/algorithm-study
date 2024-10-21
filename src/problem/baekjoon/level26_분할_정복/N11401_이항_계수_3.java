package src.problem.baekjoon.level26_분할_정복;

import java.util.Scanner;

class N11401_이항_계수_3 {

    final static long DEL = 1000000007;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int K = scanner.nextInt();

        if (K == 0 || N == K) {
            System.out.println(1);
            return;
        }

        long denominator = dc(1, K);
        long molecule = dc(N - K + 1, K);
        long answer = (molecule % DEL/ denominator% DEL) % DEL;
        System.out.println(answer);
    }

    private static long dc(long start, long len) {
        if (len == 1) {
            return start;
        }
        long temp = (dc(start, len / 2) * dc(start + len / 2, len / 2)) % DEL;
        if (len % 2 == 0) {
            return temp;
        }
        return (temp * ((start + len - 1) % DEL)) % DEL;
    }
}
