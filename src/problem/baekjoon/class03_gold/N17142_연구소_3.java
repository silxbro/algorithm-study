package src.problem.baekjoon.class03_gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

class N17142_연구소_3 {

    static int N, M;
    static int[][] map;
    static int[][] time;
    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};
    static List<int[]> viruses;
    static int emptyCount;
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        time = new int[N][N];
        viruses = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 0) {
                    emptyCount++;
                }
                if (map[i][j] == 2) {
                    viruses.add(new int[]{i, j});
                }
            }
        }
        if (emptyCount == 0) {
            System.out.println(0);
            return;
        }

        backtrack(0, new ArrayList<>());

        System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
    }

    private static void backtrack(int index, List<int[]> selected) {
        if (selected.size() == M) {
            answer = Math.min(answer, bfs(selected));
            return;
        }
        if (index == viruses.size()) {
            return;
        }
        int[] now = viruses.get(index);
        selected.add(now);
        backtrack(index + 1, selected);
        selected.remove(now);
        backtrack(index + 1, selected);
    }

    private static int bfs(List<int[]> activates) {
        int count = 0;
        for (int i = 0; i < N; i++) {
            Arrays.fill(time[i], -1);
        }
        Queue<int[]> queue = new LinkedList<>();
        for (int[] v : activates) {
            time[v[0]][v[1]] = 0;
            queue.add(new int[]{v[0], v[1]});
        }

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            for (int d = 0; d < 4; d++) {
                int nextR = now[0] + dr[d];
                int nextC = now[1] + dc[d];
                if (nextR >= 0 && nextR < N && nextC >= 0 && nextC < N && map[nextR][nextC] != 1 && time[nextR][nextC] == -1) {
                    time[nextR][nextC] = time[now[0]][now[1]] + 1;
                    queue.add(new int[]{nextR, nextC});
                    if (map[nextR][nextC] == 0) {
                        count++;
                        if (count == emptyCount) {
                            return time[nextR][nextC];
                        }
                    }
                }
            }
        }
        return Integer.MAX_VALUE;
    }
}