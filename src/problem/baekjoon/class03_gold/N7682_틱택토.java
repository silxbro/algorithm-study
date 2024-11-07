package src.problem.baekjoon.class03_gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class N7682_틱택토 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stb = new StringBuilder();
        while (true) {
            String str = br.readLine();
            if (str.equals("end")) {
                break;
            }
            stb.append(isValid(str) ? "valid" : "invalid").append("\n");
        }
        System.out.println(stb);
    }

    private static boolean isValid(String str) {
        char[][] map = new char[3][3];
        int first = 0;
        int second = 0;

        // X가 O보다 1개 더 많아야 함
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                map[i][j] = str.charAt(i * 3 + j);
                if (map[i][j] == 'X') {
                    first++;
                }
                if (map[i][j] == 'O') {
                    second++;
                }
            }
        }

        if (first != second + 1 && first != second) {
            return false;
        }

        // 빈칸이 존재할 경우 승리배열이 1세트만 있어야 함

        int[] firstWin = new int[3];
        int[] secondWin = new int[3];
        for (int i = 0; i < 3; i++) {
            if (map[i][0] == map[i][1] && map[i][1] == map[i][2]) {
                if (map[i][0] == 'X') firstWin[0]++;
                if (map[i][0] == 'O') secondWin[0]++;
            }
            if (map[0][i] == map[1][i] && map[1][i] == map[2][i]) {
                if (map[0][i] == 'X') firstWin[1]++;
                if (map[0][i] == 'O') secondWin[1]++;
            }
        }
        if (map[0][0] == map[1][1] && map[1][1] == map[2][2]) {
            if (map[0][0] == 'X') firstWin[2]++;
            if (map[0][0] == 'O') secondWin[2]++;
        }
        if (map[2][0] == map[1][1] && map[1][1] == map[0][2]) {
            if (map[2][0] == 'X') firstWin[2]++;
            if (map[2][0] == 'O') secondWin[2]++;
        }

        int firstMax = Math.max(firstWin[0], Math.max(firstWin[1], firstWin[2]));
        int secondMax = Math.max(secondWin[0], Math.max(secondWin[1], secondWin[2]));

        boolean isFirstWin = secondMax == 0 && (firstMax == 1 || firstWin[2] == 2);
        boolean isSecondWin = firstMax == 0 && (secondMax == 1 || secondWin[2] == 2);

        if (first + second == 9) {
            return (first == second + 1 && (isFirstWin || firstMax == 0 && secondMax == 0));
        }
        return (isFirstWin && first == second + 1) || (isSecondWin && first == second);
    }
}