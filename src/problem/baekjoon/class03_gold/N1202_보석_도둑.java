package src.problem.baekjoon.class03_gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class N1202_보석_도둑 {
    static int N, K;
    static int[][] MV;
    static PriorityQueue<Integer> C;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        MV = new int[N][2];
        C = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            MV[i][0] = Integer.parseInt(st.nextToken()); // 보석 무게
            MV[i][1] = Integer.parseInt(st.nextToken()); // 보석 가격
        }
        for (int i = 0; i < K; i++) {
            C.add(Integer.parseInt(br.readLine())); // 가방 최대 무게
        }

        Arrays.sort(MV, Comparator.comparing(o -> o[1], Comparator.reverseOrder()));

        long sumValue = 0;
        for (int i = 0; i < N; i++) {
            if (findWeight(MV[i][0])) {
                sumValue += MV[i][1];
            }
        }

        System.out.println(sumValue);
    }

    private static boolean findWeight(long target) {
        Integer[] weights = C.toArray(new Integer[0]);
        int position = -1;
        int s = 0;
        int e = weights.length - 1;
        while (s <= e) {
            int m = (s + e) / 2;
            if (weights[m] >= target) {
                position = m;
                e = m - 1;
            } else {
                s = m + 1;
            }
        }
        return true;
    }
}