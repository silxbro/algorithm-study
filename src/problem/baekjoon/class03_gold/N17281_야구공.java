package src.problem.baekjoon.class03_gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N17281_야구공 {

    static int N;
    static int[][] results;
    static int[] order;
    static int maxScore;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        results = new int[N][10];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < 10; j++) {
                results[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        order = new int[10];
        order[4] = 1;

        backtrack(2);

        System.out.println(maxScore);
    }

    private static void backtrack(int player) {
        if (player == 10) {
            maxScore = Math.max(maxScore, getScore());
            return;
        }
        for (int i = 1; i <= 9; i++) {
            if (order[i] == 0) {
                order[i] = player;
                backtrack(player + 1);
                order[i] = 0;
            }
        }
    }

    private static int getScore() {
        int out = 0;
        int n = 0;
        int now = 1;
        int score = 0;

        boolean[] pos = new boolean[3];
        while (true) {
            if (out == 3) {
                n++;
                out = 0;
                pos = new boolean[3];
            }
            if (n == N) {
                break;
            }
            int player = order[now];
            int result = results[n][player];

            if (result == 0) {
                out++;
            } else {
                for (int i = 2; i >= 0; i--) {
                    if (i + result >= 3) {
                        if (pos[i]) score++;
                    } else {
                        pos[i + result] = pos[i];
                    }
                    pos[i] = false;
                }

                if (result == 4) score++;
                else pos[result - 1] = true;
            }
            now++;
            if (now == 10) now = 1;
        }
        return score;
    }
}