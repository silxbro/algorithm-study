package src.problem.baekjoon.class03_gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

class N15683_감시 {

    static int N, M;
    static int[][] map;
    static boolean[][] visited;
    static List<int[]> cctvList;
    static Map<Integer, int[][]> match;
    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};
    static int[][] first = {{0}, {1}, {2}, {3}};
    static int[][] second = {{1, 3}, {0, 2}};
    static int[][] third = {{0, 1}, {1, 2}, {2, 3}, {0, 3}};
    static int[][] fourth = {{0, 1, 2}, {1, 2, 3}, {2, 3, 0}, {3, 0, 1}};
    static int[][] fifth = {{0, 1, 2, 3}};
    static int allCount;
    static int maxCount;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M];
        cctvList = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 0) {
                    allCount++;
                }
                if (map[i][j] >= 1 && map[i][j] <= 5) {
                    cctvList.add(new int[]{i, j});
                }
            }
        }

        match = Map.of(1, first, 2, second, 3, third, 4, fourth, 5, fifth);
        backtrack(0, 0);

        System.out.println(allCount - maxCount);
    }

    private static void backtrack(int index, int count) {
        if (index == cctvList.size()) {
            maxCount = Math.max(maxCount, count);
            return;
        }

        int[] now = cctvList.get(index);
        int[][] directions = match.get(map[now[0]][now[1]]);
        List<int[]> check;
        int plus;
        for (int[] dir : directions) {
            check = new ArrayList<>();
            plus = 0;
            for (int i = 0; i < dir.length; i++) {
                int drValue = dr[dir[i]];
                int dcValue = dc[dir[i]];
                while (true) {
                    int nextR = now[0] + drValue;
                    int nextC = now[1] + dcValue;
                    if (nextR >= 0 && nextR < N && nextC >= 0 && nextC < M && map[nextR][nextC] != 6) {
                        if (map[nextR][nextC] == 0 && !visited[nextR][nextC]) {
                            visited[nextR][nextC] = true;
                            plus++;
                            check.add(new int[]{nextR, nextC});
                        }
                        drValue += dr[dir[i]];
                        dcValue += dc[dir[i]];
                    } else {
                        break;
                    }
                }
            }
            backtrack(index + 1, count + plus);
            for (int[] point : check) {
                visited[point[0]][point[1]] = false;
            }
        }
    }
}