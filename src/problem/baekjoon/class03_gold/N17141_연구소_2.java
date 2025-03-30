package src.problem.baekjoon.class03_gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class N17141_연구소_2 {

    static int N, M;
    static int[][] map;
    static int[][] viruses;
    static List<int[]> selected;
    static int minTime;
    static int zeroCount;
    static int posCount;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        viruses = new int[11][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 0) {
                    zeroCount++;
                }
                if (map[i][j] == 2) {
                    posCount++;
                    zeroCount++;
                    viruses[posCount] = new int[]{i, j};
                    map[i][j] = 0;
                }
            }
        }

        selected = new ArrayList<>();
        minTime = Integer.MAX_VALUE;
        backtrack(1, 0);

        System.out.println(minTime == Integer.MAX_VALUE ? -1 : minTime);
    }

    private static void backtrack(int index, int count) {
        if (count == M) {
            int result = getMinTime();
            if (result >= 0) {
                minTime = Math.min(minTime, result);
            }
            return;
        }
        if (index > posCount) {
            return;
        }
        int[] position = viruses[index];
        selected.add(position);
        map[position[0]][position[1]] = 2;
        zeroCount--;
        backtrack(index + 1, count + 1);
        selected.remove(selected.size() - 1);
        map[position[0]][position[1]] = 0;
        zeroCount++;
        backtrack(index + 1, count);
    }

    private static int getMinTime() {
        int remained = zeroCount;
        int maxTime = 0;
        int[][] time = new int[N][N];
        int[] dr = {0, 1, 0, -1};
        int[] dc = {1, 0, -1, 0};
        Queue<int[]> queue = new LinkedList<>(selected);
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            for (int d = 0; d < 4; d++) {
                int nextR = now[0] + dr[d];
                int nextC = now[1] + dc[d];
                if (nextR >= 0 && nextR < N && nextC >= 0 && nextC < N && map[nextR][nextC] == 0 && time[nextR][nextC] == 0) {
                    time[nextR][nextC] = time[now[0]][now[1]] + 1;
                    maxTime = Math.max(maxTime, time[nextR][nextC]);
                    queue.add(new int[]{nextR, nextC});
                    remained--;
                }
            }
        }

        return remained > 0 ? -1 : maxTime;
    }
}