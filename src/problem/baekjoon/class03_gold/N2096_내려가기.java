package src.problem.baekjoon.class03_gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N2096_내려가기 {

    static int[][] map;
    static int[][] max;
    static int[][] min;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        map = new int[N][3];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        max = new int[N][3];
        min = new int[N][3];
        max[0] = map[0];
        min[0] = map[0];
        for (int i = 1; i < N; i++) {
            max[i][0] = Math.max(max[i - 1][0], max[i - 1][1]) + map[i][0];
            min[i][0] = Math.min(min[i - 1][0], min[i - 1][1]) + map[i][0];
            max[i][1] = Math.max(max[i - 1][0], Math.max(max[i - 1][1], max[i - 1][2])) + map[i][1];
            min[i][1] = Math.min(min[i - 1][0], Math.min(min[i - 1][1], min[i - 1][2])) + map[i][1];
            max[i][2] = Math.max(max[i - 1][1], max[i - 1][2]) + map[i][2];
            min[i][2] = Math.min(min[i - 1][1], min[i - 1][2]) + map[i][2];
        }

        int maxValue = Math.max(max[N - 1][0], Math.max(max[N - 1][1], max[N - 1][2]));
        int minValue = Math.min(min[N - 1][0], Math.min(min[N - 1][1], min[N - 1][2]));
        System.out.println(maxValue + " " + minValue);
    }
}