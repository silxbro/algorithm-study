package src.problem.baekjoon.level15_약수_배수와_소수_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class N2485_가로수 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] positions = new int[N];
        int gcd = 0;

        for (int i = 0; i < N; i++) {
            int position = Integer.parseInt(br.readLine());
            positions[i] = position;
            if (i == 0) {
                continue;
            }
            if (i == 1) {
                gcd = positions[1] - positions[0];
                continue;
            }
            gcd = gcd(gcd, positions[i] - positions[i - 1]);
        }
        int count = 0;
        for (int i = 1; i < positions.length; i++) {
            count += (positions[i] - positions[i - 1]) / gcd - 1;
        }
        System.out.println(count);
    }

    private static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}