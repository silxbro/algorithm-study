package src.problem.baekjoon.level31_그래프와_순회;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class N7562_나이트의_이동 {

    static int N;
    static int[][] nights;
    static int[] dr = {-1, -2, -2, -1, 1, 2, 2, 1};
    static int[] dc = {-2, -1, 1, 2, 2, 1, -1, -2};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            N = Integer.parseInt(br.readLine());
            nights = new int[N][N];

            st = new StringTokenizer(br.readLine());
            int[] start = {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
            st = new StringTokenizer(br.readLine());
            int[] end = {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};

            bfs(start[0], start[1]);
            stb.append(nights[end[0]][end[1]]).append("\n");
        }
        System.out.println(stb);
    }

    private static void bfs(int a, int b) {
        Queue<int[]> queue = new LinkedList<>();
        nights[a][b] = 0;
        queue.add(new int[]{a, b});
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            for (int d = 0; d < 8; d++) {
                int nextR = now[0] + dr[d];
                int nextC = now[1] + dc[d];
                if (nextR >= 0 && nextR < N && nextC >= 0 && nextC < N && nights[nextR][nextC] == 0) {
                    if (nextR != a || nextC != b) {
                        nights[nextR][nextC] = nights[now[0]][now[1]] + 1;
                        queue.add(new int[]{nextR, nextC});
                    }
                }
            }
        }
    }
}