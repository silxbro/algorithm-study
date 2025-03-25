package src.problem.baekjoon.class03_gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class N21608_상어_초등학교 {

    static int N;
    static int[][] map;
    static boolean[][] likeMap;
    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        likeMap = new boolean[N * N + 1][N * N + 1];
        for (int i = 0; i < N * N; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            likeMap[s][a] = true;
            likeMap[s][b] = true;
            likeMap[s][c] = true;
            likeMap[s][d] = true;
            int[] pos = getPos(s);
            map[pos[0]][pos[1]] = s;
        }

        int answer = 0;
        for (int i = 0 ; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int count = 0;
                for (int d = 0; d < 4; d++) {
                    int s = map[i][j];
                    int r = i + dr[d];
                    int c = j + dc[d];
                    if (r >= 0 && r < N && c >= 0 && c < N && likeMap[s][map[r][c]]) {
                        count++;
                    }
                }
                if (count > 0) {
                    answer += (int)Math.pow(10, count - 1);
                }
            }
        }
        System.out.println(answer);
    }

    private static int[] getPos(int s) {
        PriorityQueue<Pos> queue = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 0) {
                    int like = 0;
                    int empty = 0;
                    for (int d = 0; d < 4; d++) {
                        int r = i + dr[d];
                        int c = j + dc[d];
                        if (r >= 0 && r < N && c >= 0 && c < N) {
                            if (map[r][c] == 0) empty++;
                            if (likeMap[s][map[r][c]]) like++;
                        }
                    }
                    queue.add(new Pos(i, j, like, empty));
                }
            }
        }
        Pos best = queue.poll();
        return new int[]{best.row, best.col};
    }
}

class Pos implements Comparable<Pos> {

    int row;
    int col;
    int like;
    int empty;

    public Pos(int row, int col, int like, int empty) {
        this.row = row;
        this.col = col;
        this.like = like;
        this.empty = empty;
    }

    @Override
    public int compareTo(Pos o) {
        if (like == o.like && empty == o.empty && row == o.row) {
            return col - o.col;
        }
        if (like == o.like && empty == o.empty) {
            return row - o.row;
        }
        if (like == o.like) {
            return o.empty - empty;
        }
        return o.like - like;
    }
}