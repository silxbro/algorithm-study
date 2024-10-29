package src.problem.baekjoon.level27_이분_탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class N2110_공유기_설치 {

    static long[] positions;
    static int N, C;
    static long answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        positions = new long[N];
        for (int i = 0; i < N; i++) {
            positions[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(positions);

        binarySearch(1, positions[positions.length - 1] - positions[0]);

        System.out.println(answer);
    }

    private static void binarySearch(long s, long e) {
        if (s <= e) {
            long m = (s + e) / 2; // 최소 거리의 최대
            long last = positions[0];
            long count = 1;
            for (int i = 1; i < positions.length; i++) {
                if (positions[i] >= last + m) {
                    count++;
                    last = positions[i];
                }
            }

            if (count >= C) {
                answer = m;
                binarySearch(m + 1, e);
            } else {
                binarySearch(s, m - 1);
            }
        }
    }
}