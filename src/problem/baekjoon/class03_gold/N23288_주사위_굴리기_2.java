package src.problem.baekjoon.class03_gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class N23288_주사위_굴리기_2 {

    static int N, M, K;
    static int[][] map;
    static int[] dice;
    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int score = 0;
        int[] pos = {0, 0};
        dice = new int[]{1, 2, 3, 5, 4, 6};
        int dir = 0;
        for (int i = 0; i < K; i++) {
            pos = getPos(pos, dir);
            updateDice(dir);
            score += getScore(pos);
            dir = getDir(pos, dir);
        }
        System.out.println(score);
    }

    private static int[] getPos(int[] now, int dir) {
        int nextR = now[0] + dr[dir];
        int nextC = now[1] + dc[dir];
        return new int[]{nextR, nextC};
    }

    private static void updateDice(int dir) {
        int[] nextDice = new int[6];
        nextDice[0] = dice[dir == 0 ? dir + 4 : dir];
        nextDice[1] = dir == 1 ? dice[5] : dir == 3 ? dice[0] : dice[1];
        nextDice[2] = dir == 0 ? dice[0] : dir == 2 ? dice[5] : dice[2];
        nextDice[3] = dir == 1 ? dice[0] : dir == 3 ? dice[5] : dice[3];
        nextDice[4] = dir == 0 ? dice[5] : dir == 2 ? dice[0] : dice[4];
        nextDice[5] = dice[dir + 2 > 4 ? dir - 2 : dir + 2];

        dice = nextDice;
    }

    private static int getScore(int[] pos) {
        int score = 0;
        boolean[][] visited = new boolean[N][M];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(pos);
        visited[pos[0]][pos[1]] = true;
        score++;
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            for (int d = 0; d < 4; d++) {
                int nextR = now[0] + dr[d];
                int nextC = now[1] + dc[d];
                if (nextR >= 0 && nextR < N && nextC >= 0 && nextC < M && !visited[nextR][nextC] && map[nextR][nextC] == map[now[0]][now[1]]) {
                    visited[nextR][nextC] = true;
                    score++;
                    queue.add(new int[]{nextR, nextC});
                }
            }
        }
        return map[pos[0]][pos[1]] * score;
    }

    private static int getDir(int[] pos, int dir) {
        int nextDir = dir;
        int A = dice[5];
        int B = map[pos[0]][pos[1]];
        if (A > B) {
            nextDir++;
        }
        if (A < B) {
            nextDir--;
        }
        nextDir = nextDir == 4 ? 0 : nextDir == -1 ? 3 : nextDir;
        int nextR = pos[0] + dr[nextDir];
        int nextC = pos[1] + dc[nextDir];
        if (nextR < 0 || nextR >= N || nextC < 0 || nextC >= M) {
            nextDir = (nextDir + 2) % 4;
        }
        return nextDir;
    }
}