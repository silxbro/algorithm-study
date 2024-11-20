package src.problem.baekjoon.class03_gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

class N3190_뱀 {

    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());

        int[][] map = new int[N][N];
        map[0][0] = -1;
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            map[r - 1][c - 1] = 1;
        }

        int L = Integer.parseInt(br.readLine());
        int[] dirChange = new int[10001];
        for (int i = 0; i < L; i++) {
            st = new StringTokenizer(br.readLine());
            int time = Integer.parseInt(st.nextToken());
            char change = st.nextToken().charAt(0);
            dirChange[time] = change == 'L' ? -1 : 1;
        }

        Deque<int[]> body = new LinkedList<>();
        body.add(new int[]{0, 0});
        int dir = 0;
        int time = 1;

        while(true) {
            int[] head = body.getFirst();
            int nextR = head[0] + dr[dir];
            int nextC = head[1] + dc[dir];
            if (nextR < 0 || nextR >= N || nextC < 0 || nextC >= N || map[nextR][nextC] == -1) {
                break;
            }
            if (map[nextR][nextC] == 0) {
                int[] tail = body.removeLast();
                map[tail[0]][tail[1]] = 0;
            }
            body.addFirst(new int[]{nextR, nextC});
            map[nextR][nextC] = -1;

            dir += dirChange[time];
            if (dir == -1) {
                dir = 3;
            }
            if (dir == 4) {
                dir = 0;
            }
            time++;
        }

        System.out.println(time);
    }
}