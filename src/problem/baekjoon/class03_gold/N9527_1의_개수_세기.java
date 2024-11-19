package src.problem.baekjoon.class03_gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class N9527_1의_개수_세기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());

        long minCount = countBitsUpTo(A - 1);
        long maxCount = countBitsUpTo(B);

        System.out.println(maxCount - minCount);
    }

    public static long countBitsUpTo(long n) {
        long count = 0;
        long powerOfTwo = 1; // 2^0

        while (powerOfTwo <= n) {
            long totalPairs = n / (powerOfTwo * 2);
            count += totalPairs * powerOfTwo;
            long remainder = n % (powerOfTwo * 2);
            count += Math.max(0, remainder - powerOfTwo + 1);

            powerOfTwo *= 2;
        }

        return count;
    }
}