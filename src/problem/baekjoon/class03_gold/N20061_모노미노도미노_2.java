package src.problem.baekjoon.class03_gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N20061_모노미노도미노_2 {
    static int score;
    static int row = 6;
    static int col = 4;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        boolean[][] grMap = new boolean[row][col];
        boolean[][] blMap = new boolean[row][col];

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            putBlock(t, x, y, grMap, blMap);
            calculateScore(grMap);
            calculateScore(blMap);
            arrangeMap(grMap);
            arrangeMap(blMap);
        }

        System.out.println(score);
        System.out.println(getCount(grMap, blMap));
    }

    private static void putBlock(int t, int x, int y, boolean[][] grMap, boolean[][] blMap) {
        int gRow = getPutRow(t, y, true, grMap);
        int bRow = getPutRow(t, x, false, blMap);
        grMap[gRow][y] = true;
        blMap[bRow][x] = true;

        if (t == 2) {
            grMap[gRow][y + 1] = true;
            blMap[bRow - 1][x] = true;
        }
        if (t == 3) {
            grMap[gRow - 1][y] = true;
            blMap[bRow][x + 1] = true;
        }
    }

    private static int getPutRow(int t, int c, boolean isGreen, boolean[][] map) {
        for (int i = 0; i < row; i++) {
            if (t == 1 && map[i][c]) {
                return i - 1;
            }
            if (t == 2) {
                if (!isGreen && map[i][c]) return i - 1;
                if (isGreen && (map[i][c] || map[i][c + 1])) return i - 1;
            }
            if (t == 3) {
                if (isGreen && map[i][c]) return i - 1;
                if (!isGreen && (map[i][c] || map[i][c + 1])) return i - 1;
            }
        }
        return row - 1;
    }

    private static void calculateScore(boolean[][] map) {
        for (int i = row - 1; i >= 0; i--) {
            boolean allExist = true;
            for (int j = 0; j < col; j++) {
                if (!map[i][j]) {
                    allExist = false;
                    break;
                }
            }
            if (allExist) {
                score++;
                for (int j = i - 1; j >= 0; j--) {
                    map[j + 1] = Arrays.copyOf(map[j], col);
                }
                Arrays.fill(map[0], false);
                i++;
            }
        }
    }

    private static void arrangeMap(boolean[][] map) {
        for (int i = 0; i < col; i++) {
            if (map[0][i]) {
                for (int j = row - 3; j >= 0; j--) {
                    map[j + 2] = Arrays.copyOf(map[j], col);
                }
                Arrays.fill(map[0], false);
                Arrays.fill(map[1], false);
                return;
            }
        }
        for (int i = 0; i < col; i++) {
            if (map[1][i]) {
                for (int j = row - 2; j >= 0; j--) {
                    map[j + 1] = Arrays.copyOf(map[j], col);
                }
                Arrays.fill(map[0], false);
            }
        }
    }

    private static int getCount(boolean[][] grMap, boolean[][] blMap) {
        int count = 0;
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 4; j++) {
                if (grMap[i][j]) {
                    count++;
                }
                if (blMap[i][j]) {
                    count++;
                }
            }
        }
        return count;
    }
}
