package src.problem.baekjoon.class03_gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class N14658_하늘에서_별똥별이_빗발친다 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] stars = new int[K][2];
        int[] rows = new int[K];
        int[] cols = new int[K];

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            stars[i][0] = Integer.parseInt(st.nextToken());
            stars[i][1] = Integer.parseInt(st.nextToken());
            rows[i] = stars[i][0];
            cols[i] = stars[i][1];
        }

        Arrays.sort(rows);
        Arrays.sort(cols);

        int maxCount = 0;
        for (int i = 0; i < K; i++) {
            for (int j = 0; j < K; j++) {
                int row = rows[i];
                int col = cols[i];
                int count1 = 0;
                int count2 = 0;
                for (int k = 0; k < K; k++) {
                    if (stars[k][0] >= row && stars[k][0] <= row + L && stars[k][1] >= col && stars[k][1] <= col + L) {
                        count1++;
                    }
                    if (stars[k][0] <= row && stars[k][0] >= row - L && stars[k][1] <= col && stars[k][1] >= col - L) {
                        count2++;
                    }
                }
                maxCount = Math.max(maxCount, Math.max(count1, count2));
            }
        }
        System.out.println(K - maxCount);
    }
}