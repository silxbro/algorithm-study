package src.problem.baekjoon.level11_시간_복잡도;

    import java.util.Scanner;

    class N24313_알고리즘_수업_점근적_표기_1 {

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            long a1 = scanner.nextLong();
            long a0 = scanner.nextLong();
            long c = scanner.nextLong();
            long n0 = scanner.nextLong();

            long cal1 = a1 * n0 + a0;
            long cal2 = c * n0;
            if (a1 > c || cal2 < cal1) {
                System.out.println(0);
                return;
            }
            System.out.println(1);
        }
    }