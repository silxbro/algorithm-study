package src.problem.baekjoon.class03_gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class N17143_낚시왕 {

    static int R, C, M;
    static Shark[][] map;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, 1, -1};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new Shark[R][C];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());
            map[r - 1][c - 1] = new Shark(s, d, z);
        }


        int answer = 0;
        for (int i = 0; i < C; i++) {
            for (int j = 0; j < R; j++) {
                if (map[j][i] != null) {
                    answer += map[j][i].z;
                    map[j][i] = null;
                    break;
                }
            }
            moveShark();
        }

        System.out.println(answer);
    }

    private static void moveShark() {
        Shark[][] newMap = new Shark[R][C];
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] != null) {
                    NextShark nextShark = getNextShark(i, j, map[i][j]);
                    if (newMap[nextShark.r][nextShark.c] != null && newMap[nextShark.r][nextShark.c].z > map[i][j].z) {
                        continue;
                    }
                    newMap[nextShark.r][nextShark.c] = nextShark.shark;
                }
            }
        }
        map = newMap;
    }

    private static NextShark getNextShark(int r, int c, Shark now) {
        int dist = now.s % (2 * (now.d <= 2 ? R - 1 : C - 1));
        int count = 0;
        int row = r;
        int col = c;
        int dir = now.d;
        while (count < dist) {
            int nextR = row + dr[dir - 1];
            int nextC = col + dc[dir - 1];
            if (nextR >= 0 && nextR < R && nextC >= 0 && nextC < C) {
                count++;
                row = nextR;
                col = nextC;
                continue;
            }
            dir = dir % 2 == 0 ? dir - 1 : dir + 1;
        }
        return new NextShark(row, col, new Shark(now.s, dir, now.z));
    }
}
class Shark {

    int s; //속력
    int d; //이동방향
    int z; //크기

    public Shark(int s, int d, int z) {
        this.s = s;
        this.d = d;
        this.z = z;
    }
}

class NextShark {

    int r;
    int c;
    Shark shark;

    public NextShark(int r, int c, Shark shark) {
        this.r = r;
        this.c = c;
        this.shark = shark;
    }
}