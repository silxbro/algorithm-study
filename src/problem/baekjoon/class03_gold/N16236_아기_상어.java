package src.problem.baekjoon.class03_gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

class N16236_아기_상어 {
    static int N;
    static int[][] map;
    static List<int[]> fishes;
    static int[] shark = new int[2];
    static int answer;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        fishes = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] >= 1 && map[i][j] <= 6) {
                    fishes.add(new int[]{i, j});
                }
                if (map[i][j] == 9) {
                    shark[0] = i;
                    shark[1] = j;
                    map[i][j] = 0;
                }
            }
        }

        simulate(shark[0], shark[1], 2, 0);

        System.out.println(answer);
    }

    private static void simulate(int r, int c, int size, int count) {
        PriorityQueue<Position> queue = new PriorityQueue<>();
        int[][] dist = getDist(r, c, size);
        for (int i = 0; i < fishes.size(); i++) {
            int[] fish = fishes.get(i);
            int fishSize = map[fish[0]][fish[1]];
            int fishDist = dist[fish[0]][fish[1]];
            if (fishSize > 0 && fishSize < size && fishDist > 0) {
                queue.add(new Position(fish[0], fish[1], fishDist));
            }
        }
        if (queue.isEmpty()) {
            return;
        }
        Position selected = queue.poll();
        map[selected.r][selected.c] = 0;
        answer += selected.dist;
        if (size == count + 1) {
            simulate(selected.r, selected.c, size + 1, 0);
        } else {
            simulate(selected.r, selected.c, size, count + 1);
        }
    }

    private static int[][] getDist(int r, int c, int size) {
        int[][] dist = new int[N][N];
        int[] dr = {0, 1, 0, -1};
        int[] dc = {1, 0, -1, 0};
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{r, c});
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            for (int d = 0; d < 4; d++) {
                int nextR = now[0] + dr[d];
                int nextC = now[1] + dc[d];
                if (nextR >= 0 && nextR < N && nextC >= 0 && nextC < N && (nextR != r || nextC != c) && map[nextR][nextC] <= size && dist[nextR][nextC] == 0) {
                    dist[nextR][nextC] = dist[now[0]][now[1]] + 1;
                    queue.add(new int[]{nextR, nextC});
                }
            }
        }
        return dist;
    }

}

class Position implements Comparable<Position> {
    int r;
    int c;
    int dist;

    public Position(int r, int c, int dist) {
        this.r = r;
        this.c = c;
        this.dist = dist;
    }

    @Override
    public int compareTo(Position o) {
        if (dist == o.dist && r == o.r) {
            return c - o.c;
        }
        if (dist == o.dist) {
            return r - o.r;
        }
        return dist - o.dist;
    }
}