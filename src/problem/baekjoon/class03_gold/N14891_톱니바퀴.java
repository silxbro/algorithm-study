package src.problem.baekjoon.class03_gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N14891_톱니바퀴 {
    static int[][] wheels;
    static int[] dirs;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        wheels = new int[4][8];
        for (int i = 0; i < 4; i++) {
            String line = br.readLine();
            for (int j = 0; j < 8; j++) {
                wheels[i][j] = line.charAt(j) - '0';
            }
        }

        int K = Integer.parseInt(br.readLine());
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int target = Integer.parseInt(st.nextToken()) - 1;
            int dir = Integer.parseInt(st.nextToken());
            dirs = new int[4];
            dirs[target] = dir;
            decideDir(target - 1, target);
            decideDir(target + 1, target);
            turn();
        }

        int score = 0;
        for (int i = 0; i < 4; i++) {
            if (wheels[i][0] == 1) {
                score += (int) Math.pow(2, i);
            }
        }
        System.out.println(score);
    }

    private static void decideDir(int now, int before) {
        if (now < 0 || now > 3 || dirs[before] == 0) {
            return;
        }
        if (now < before && wheels[now][2] != wheels[before][6]) {
            dirs[now] = dirs[before] * (-1);
            decideDir(now - 1, now);
        }
        if (before < now && wheels[before][2] != wheels[now][6]) {
            dirs[now] = dirs[before] * (-1);
            decideDir(now + 1, now);
        }
    }

    private static void turn() {
        for (int d = 0; d < dirs.length; d++) {
            if (dirs[d] == 1) {
                int[] newWheel = new int[8];
                for (int i = 0; i < 8; i++) {
                    newWheel[i] = wheels[d][(i + 7) % 8];
                }
                wheels[d] = newWheel;
            }
            if (dirs[d] == -1) {
                int[] newWheel = new int[8];
                for (int i = 0; i < 8; i++) {
                    newWheel[i] = wheels[d][(i + 1) % 8];
                }
                wheels[d] = newWheel;
            }
        }
    }
}