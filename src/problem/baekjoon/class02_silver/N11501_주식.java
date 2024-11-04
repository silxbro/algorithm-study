package src.problem.baekjoon.class02_silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class N11501_주식 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        int[] price;
        StringBuilder stb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            price = new int[N];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                price[i] = Integer.parseInt(st.nextToken());
            }

            long benefit = 0;
            int maxPrice = price[N - 1];
            for (int i = N - 2; i >= 0; i--) {
                if (price[i] <= maxPrice) {
                    benefit += maxPrice - price[i];
                } else {
                    maxPrice = price[i];
                }
            }

            stb.append(benefit).append("\n");
        }
        System.out.println(stb);
    }
}