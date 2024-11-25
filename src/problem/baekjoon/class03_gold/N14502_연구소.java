package src.problem.baekjoon.class03_gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

class N14502_연구소 {

    static int N, M;
    static int[][] map;
    static boolean[][] visited;
    static List<int[]> empties;
    static List<int[]> viruses;
    static int totalCount, maxCount = 0;
    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        empties = new ArrayList<>();
        viruses = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 0) {
                    empties.add(new int[]{i, j});
                    totalCount++;
                }
                if (map[i][j] == 2) {
                    viruses.add(new int[]{i, j});
                }
            }
        }

        totalCount -= 3; // 벽으로 지정할 3개 제외

        backtrack(0, new ArrayList<>());

        System.out.println(maxCount);
    }

    private static void backtrack(int index, List<int[]> selected) {
        if (selected.size() == 3) {
            maxCount = Math.max(maxCount, totalCount - getCount(selected));
            return;
        }

        if (index == empties.size()) {
            return;
        }

        selected.add(empties.get(index));
        backtrack(index + 1, selected);
        selected.remove(selected.size() - 1);
        backtrack(index + 1, selected);
    }

    private static int getCount(List<int[]> selected) {
        int count = 0;
        visited = new boolean[N][M];
        Queue<int[]> queue = new LinkedList<>(viruses);
        for (int[] wall : selected) {
            map[wall[0]][wall[1]] = 1;
        }

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            for (int d = 0; d < 4; d++) {
                int nextR = now[0] + dr[d];
                int nextC = now[1] + dc[d];
                if (nextR >= 0 && nextR < N && nextC >= 0 && nextC < M && map[nextR][nextC] == 0 && !visited[nextR][nextC]) {
                    visited[nextR][nextC] = true;
                    count++;
                    queue.add(new int[]{nextR, nextC});
                }
            }
        }
        for (int[] wall : selected) {
            map[wall[0]][wall[1]] = 0;
        }
        return count;
    }
}