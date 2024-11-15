package src.problem.baekjoon.class03_gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class N22251_빌런_호석 {

    static int[][] changeCount;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        init();

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        int answer = 0;
        for (int i = 1; i <= N; i++) {
            if (i != X) {
                int target = i;
                int nowStair = X;
                int count = 0;
                for (int k = 1; k <= K; k++) {
                    count += changeCount[target % 10][nowStair % 10];
                    target /= 10;
                    nowStair /= 10;
                }
                if (count <= P) {
                    answer++;
                }
            }
        }

        System.out.println(answer);

    }

    private static void init() {
        boolean[][] light = new boolean[10][7];
        light[0] = new boolean[]{true, true, true, true, true, true, false};
        light[1] = new boolean[]{false, false, true, true, false, false, false};
        light[2] = new boolean[]{false, true, true, false, true, true, true};
        light[3] = new boolean[]{false, true, true, true, true, false, true};
        light[4] = new boolean[]{true, false, true, true, false, false, true};
        light[5] = new boolean[]{true, true, false, true, true, false, true};
        light[6] = new boolean[]{true, true, false, true, true, true, true};
        light[7] = new boolean[]{false, true, true, true, false, false, false};
        light[8] = new boolean[]{true, true, true, true, true, true, true};
        light[9] = new boolean[]{true, true, true, true, true, false, true};

        changeCount = new int[10][10];
        for (int i = 0; i < 9; i++) {
            for (int j = i + 1; j < 10; j++) {
                int count = 0;
                for (int k = 0; k < 7; k++) {
                    if (light[i][k] != light[j][k]) {
                        count++;
                    }
                }
                changeCount[i][j] = count;
                changeCount[j][i] = count;
            }
        }
    }
}