package src.problem.baekjoon.level22_백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class N2580_스도쿠 {

    static int[][] map;
    static boolean clear;
    static List<int[]> zeroList;

    public static void main(String[] args) throws IOException {
        map = new int[9][9];
        zeroList = new ArrayList<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for (int i = 0; i < 9; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 0) {
                    zeroList.add(new int[]{i, j});
                }
            }
        }

        backtrack(0);

        StringBuilder stb = new StringBuilder();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                stb.append(map[i][j]).append(" ");
            }
            stb.append("\n");
        }
        System.out.println(stb);
    }

    private static void backtrack(int p) {
        if (p == zeroList.size()) {
            clear = true;
            return;
        }
        int r = zeroList.get(p)[0];
        int c = zeroList.get(p)[1];
        for (int n = 1; n <= 9; n++) {
            if (possible(r, c, n)) {
                map[r][c] = n;
                backtrack(p + 1);
                if (!clear) {
                    map[r][c] = 0;
                }
            }
        }
    }

    private static boolean possible(int row, int col, int num) {
        for (int i = 0; i < 9; i++) {
            if (i != row && map[i][col] == num) {
                return false;
            }
            if (i != col && map[row][i] == num) {
                return false;
            }
        }
        int sRow = (row / 3) * 3;
        int sCol = (col / 3) * 3;
        for (int i = sRow; i < sRow + 3; i++) {
            for (int j = sCol; j < sCol + 3; j++) {
                if (i != row && j != col && map[i][j] == num) {
                    return false;
                }
            }
        }
        return true;
    }
}