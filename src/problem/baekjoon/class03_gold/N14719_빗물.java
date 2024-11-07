package src.problem.baekjoon.class03_gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class N14719_빗물 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        int[] height = new int[W];
        int maxHeight = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < W; i++) {
            height[i] = Integer.parseInt(st.nextToken());
            maxHeight = Math.max(maxHeight, height[i]);
        }

        int s = 0;
        int e = W - 1;

        int leftMax = 0;
        int rigntMax = 0;
        int result = 0;
        while (height[s] < maxHeight) {
            leftMax = Math.max(leftMax, height[s]);
            result += leftMax - height[s];
            s++;
        }
        while (height[e] < maxHeight) {
            rigntMax = Math.max(rigntMax, height[e]);
            result += rigntMax - height[e];
            e--;
        }
        for (int i = s; i <= e; i++) {
            result += maxHeight - height[i];
        }
        System.out.println(result);
    }
}