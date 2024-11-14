package src.problem.baekjoon.class03_gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            stars[i][0] = Integer.parseInt(st.nextToken());
            stars[i][1] = Integer.parseInt(st.nextToken());
        }

        int maxCount = 0;
        for (int i = 0; i < K; i++) {
            for (int j = 0; j < K; j++) {
                int row = stars[i][0];
                int col = stars[j][1];
                int count = 0;
                for (int k = 0; k < K; k++) {
                    if (stars[k][0] >= row && stars[k][0] <= row + L && stars[k][1] >= col && stars[k][1] <= col + L) {
                        count++;
                    }
                }
                maxCount = Math.max(maxCount, count);
            }
        }
        System.out.println(K - maxCount);
    }
}