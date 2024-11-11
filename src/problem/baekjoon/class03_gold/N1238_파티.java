package src.problem.baekjoon.class03_gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class N1238_파티 {

    static int N, M, X;
    static List<Road>[] map;
    static boolean[] visited;
    static int[] time;
    static int[] fTime;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        map = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) {
            map[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            map[s].add(new Road(e, t));
        }

        time = new int[N + 1];
        fTime = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            dijkstra(i);
            if (i != X) {
                fTime[i] += time[X];
            } else {
                for (int j = 1; j <= N; j++) {
                    fTime[j] += time[j];
                }
            }
        }

        int maxTime = 0;
        for (int i = 1; i <= N; i++) {
            maxTime = Math.max(maxTime, fTime[i]);
        }
        System.out.println(maxTime);
    }

    private static void dijkstra(int start) {
        Arrays.fill(time, Integer.MAX_VALUE);
        time[start] = 0;
        visited = new boolean[N + 1];
        PriorityQueue<Road> queue = new PriorityQueue<>(Comparator.comparing(o -> o.time));
        queue.add(new Road(start, 0));
        while (!queue.isEmpty()) {
            Road now = queue.poll();
            if (visited[now.city]) continue;
            visited[now.city] = true;
            for (Road next : map[now.city]) {
                if (time[next.city] > now.time + next.time) {
                    time[next.city] = now.time + next.time;
                    queue.add(new Road(next.city, time[next.city]));
                }
            }
        }
    }
}

class Road {
    int city;
    int time;
    Road(int city, int time) {
        this.city = city;
        this.time = time;
    }
}