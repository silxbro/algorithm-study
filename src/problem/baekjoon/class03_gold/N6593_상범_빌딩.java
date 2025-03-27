package src.problem.baekjoon.class03_gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class N6593_상범_빌딩 {

    static int[] dr = {0, 0, 0, 0, 1, -1};
    static int[] dc = {0, 0, 1, -1, 0, 0};
    static int[] dl = {1, -1, 0, 0, 0, 0};
    static int L, R, C;
    static int[][][] building;
    static int[] start, end;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder stb = new StringBuilder();

        while (true) {
            st = new StringTokenizer(br.readLine());

            L = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());

            if (L == 0 && R == 0 && C == 0) break;

            building = new int[L][R][C];
            for (int l = 0; l < L; l++) {
                for (int i = 0; i < R; i++) {
                    String line = br.readLine();
                    for (int j = 0; j < C; j++) {
                        char c = line.charAt(j);
                        if (c == 'S') {
                            building[l][i][j] = 1;
                            start = new int[]{l, i, j};
                        }
                        if (c == 'E') {
                            end = new int[]{l, i, j};
                        }
                        if (c == '#') {
                            building[l][i][j] = -1;
                        }
                    }
                }
                br.readLine();
            }

            int result = run();
            stb.append(result == 0 ? "Trapped!" : String.format("Escaped in %d minute(s).", result)).append("\n");

        }

        System.out.println(stb);
    }

    private static int run() {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(start);
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            if (Arrays.equals(now, end)) {
                return building[end[0]][end[1]][end[2]] - 1;
            }
            for (int d = 0; d < 6; d++) {
                int nextL = now[0] + dl[d];
                int nextR = now[1] + dr[d];
                int nextC = now[2] + dc[d];
                if (nextL >= 0 && nextL < L && nextR >= 0 && nextR < R && nextC >= 0 && nextC < C && building[nextL][nextR][nextC] == 0) {
                    building[nextL][nextR][nextC] = building[now[0]][now[1]][now[2]] + 1;
                    queue.add(new int[]{nextL, nextR, nextC});
                }
            }
        }
        return 0;
    }
}