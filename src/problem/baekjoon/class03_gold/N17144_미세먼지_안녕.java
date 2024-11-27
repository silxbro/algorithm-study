package src.problem.baekjoon.class03_gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class N17144_미세먼지_안녕 {

    static int R, C, T;
    static int[][] map;
    static int[] cleaner1, cleaner2;
    static int[] dr = {1, 0, -1, 0};
    static int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        map = new int[R][C];
        cleaner1 = new int[2];
        cleaner2 = new int[2];
        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == -1) {
                    if (cleaner1[0] != 0) {
                        cleaner2[0] = i;
                        cleaner2[1] = j;
                    } else {
                        cleaner1[0] = i;
                        cleaner1[1] = j;
                    }
                }
            }
        }

        for (int t = 0; t < T; t++) {
            spread();
            rotate(cleaner1, false, 2);
            rotate(cleaner2, true, 0);
        }

        int sum = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                sum += map[i][j];
            }
        }

        System.out.println(sum);

    }

    private static void spread() {
        int[][] newMap = new int[R][C];
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] > 0) {
                    int q = map[i][j];
                    for (int d = 0; d < 4; d++) {
                        int nextR = i + dr[d];
                        int nextC = j + dc[d];
                        int[] next = new int[]{nextR, nextC};
                        if (nextR >= 0 && nextR < R && nextC >= 0 && nextC < C && !Arrays.equals(cleaner1, next) && !Arrays.equals(cleaner2, next)) {
                            newMap[nextR][nextC] += map[i][j] / 5;
                            q -= map[i][j] / 5;
                        }
                    }
                    newMap[i][j] += q;
                }
            }
        }
        map = newMap;
    }

    private static void rotate(int[] cleaner, boolean clockwise, int firstDir) {
        int dir = firstDir;
        int dirDiff = clockwise ? 1 : -1;
        int min = clockwise ? cleaner2[0] : 0;
        int max = clockwise ? R - 1 : cleaner1[0];
        int r = cleaner[0] + dr[dir];
        int c = cleaner[1] + dc[dir];
        while (true) {
            if (r == cleaner[0] && c == cleaner[1]) {
                break;
            }
            int nextR = r + dr[dir];
            int nextC = c + dc[dir];
            if (nextR < min || nextR > max || nextC < 0 || nextC >= C) {
                dir = (dir + dirDiff + 4) % 4;
            } else {
                map[r][c] = map[nextR][nextC];
                r = nextR;
                c = nextC;
            }
        }
    }
}