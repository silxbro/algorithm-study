package src.problem.baekjoon.class02_silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class N17266_어두운_굴다리 {

    static int N, M;
    static int[] light;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        light = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            light[i] = Integer.parseInt(st.nextToken());
        }

        binarySearch(1, N);

        System.out.println(answer);
    }

    private static void binarySearch(int s, int e) {
        if (s <= e) {
            int m = (s + e) / 2;
            if (irradiateAll(m)) {
                answer = m;
                binarySearch(s, m - 1);
            } else {
                binarySearch(m + 1, e);
            }
        }
    }

    private static boolean irradiateAll(int height) {
        int end = 0;
        for (int i = 0; i < light.length; i++) {
            if (light[i] - height <= end) {
                end = light[i] + height;
            } else {
                return false;
            }
        }
        return end >= N;
    }
}