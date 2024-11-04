package src.problem.baekjoon.class02_silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class N2304_창고_다각형 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int minP = 1000;
        int maxP = 1;
        int maxH = 0;
        int[] height = new int[1001];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            minP = Math.min(minP, r);
            maxP = Math.max(maxP, r);
            maxH = Math.max(maxH, h);
            height[r] = h;
        }

        int max = 0;
        int index1 = minP;
        int answer = 0;
        while (height[index1] < maxH) {
            max = Math.max(max, height[index1]);
            answer += max;
            index1++;
        }
        max = 0;
        int index2 = maxP;
        while (height[index2] < maxH) {
            max = Math.max(max, height[index2]);
            answer += max;
            index2--;
        }
        answer += maxH * (index2 - index1 + 1);

        System.out.println(answer);
    }
}