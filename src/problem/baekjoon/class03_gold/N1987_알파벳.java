package src.problem.baekjoon.class03_gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class N1987_알파벳 {

    static int R, C;
    static char[][] map;
    static boolean[] visited;
    static int answer;
    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        visited = new boolean[26];
        for (int i = 0; i < R; i++) {
            String line = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = line.charAt(j);
            }
        }

        visited[map[0][0] - 'A'] = true;
        dfs(0, 0, 1);

        System.out.println(answer);
    }

    private static void dfs(int i, int j, int count) {
        boolean nextExist = false;
        for (int d = 0; d < 4; d++) {
            int nextR = i + dr[d];
            int nextC = j + dc[d];
            if (nextR >= 0 && nextR < R && nextC >= 0 && nextC < C && !visited[map[nextR][nextC] - 'A']) {
                nextExist = true;
                visited[map[nextR][nextC] - 'A'] = true;
                dfs(nextR, nextC, count + 1);
                visited[map[nextR][nextC] - 'A'] = false;
            }
        }
        if (!nextExist) {
            answer = Math.max(answer, count);
        }
    }
}