package src.problem.baekjoon.level37_최소_신장_트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

class N17472_다리_만들기_2 {

    static int N, M;
    static int[][] map;
    static boolean[][] visited;
    static List<List<int[]>> totalList;
    static List<int[]> sumList;
    static PriorityQueue<Bridge> bridges;
    static int[] parent;
    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        totalList = new ArrayList<>();
        int num = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!visited[i][j] && map[i][j] == 1) {
                    bfs(i, j, ++num);
                    totalList.add(sumList);
                }
            }
        }

        parent = new int[num + 1];
        for (int i = 1; i <= num; i++) {
            parent[i] = i;
        }

        bridges = new PriorityQueue<>(Comparator.comparing(bridge -> bridge.e));
        bridgeExplore();

        int count = 0;
        int length = 0;
        while (!bridges.isEmpty() && count < num - 1) {
            Bridge bridge = bridges.poll();
            if (!checkLink(bridge.a, bridge.b)) {
                link(bridge.a, bridge.b);
                count++;
                length += bridge.e;
            }
        }

        if (count != num - 1) {
            length = -1;
        }
        System.out.println(length);
    }

    private static void link(int a, int b) {
        a = find(a);
        b = find(b);
        parent[b] = a;
    }

    private static int find(int a) {
        if (a == parent[a]) {
            return a;
        }
        return parent[a] = find(parent[a]);
    }

    private static boolean checkLink(int a, int b) {
        return find(a) == find(b);
    }

    private static void bfs(int a, int b, int num) {
        Queue<int[]> queue = new LinkedList<>();
        sumList = new ArrayList<>();

        visited[a][b] = true;
        map[a][b] = num;
        queue.add(new int[]{a, b});
        sumList.add(new int[]{a, b});
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            for (int d = 0; d < 4; d++) {
                int nextR = now[0] + dr[d];
                int nextC = now[1] + dc[d];
                if (nextR >= 0 && nextR < N && nextC >= 0 && nextC < M && !visited[nextR][nextC] && map[nextR][nextC] == 1) {
                    visited[nextR][nextC] = true;
                    map[nextR][nextC] = num;
                    queue.add(new int[]{nextR, nextC});
                    sumList.add(new int[]{nextR, nextC});
                }
            }
        }
    }

    private static void bridgeExplore() {
        for (int i = 0; i < totalList.size(); i++) {
            for (int[] position : totalList.get(i)) {
                for (int d = 0; d < 4; d++) {
                    int len = 0;
                    int r = position[0] + dr[d];
                    int c = position[1] + dc[d];
                    while (r >= 0 && r < N && c >= 0 && c < M && map[r][c] == 0) {
                        len++;
                        if (d == 0) {
                            c++;
                        } else if (d == 1) {
                            r++;
                        } else if (d == 2) {
                            c--;
                        } else {
                            r--;
                        }
                    }
                    if (len >= 2 && r >= 0 && r < N && c >= 0 && c < M) {
                        bridges.add(new Bridge(map[position[0]][position[1]], map[r][c], len));
                    }
                }
            }
        }
    }

}

class Bridge {
    int a;
    int b;
    int e;
    Bridge(int a, int b, int e) {
        this.a = a;
        this.b = b;
        this.e = e;
    }
}