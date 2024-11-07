package src.problem.baekjoon.class03_gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class N16928_뱀과_사다리_게임 {

    static int N, M;
    static int[] dist;
    static int[] to;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        dist = new int[101];
        to = new int[101];
        Arrays.fill(dist, -1);

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N + M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            to[s] = e;
        }

        bfs(1);

        System.out.println(dist[100]);
    }

    private static void bfs(int start) {
        dist[start] = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        while (!queue.isEmpty()) {
            int now = queue.poll();
            if (now == 100) {
                break;
            }
            for (int i = 1; i <= 6; i++) {
                int next = now + i;
                if (next > 0 && next <= 100) {
                    if (to[next] != 0) {
                        next = to[next];
                    }
                    if (dist[next] == -1) {
                        dist[next] = dist[now] + 1;
                        queue.add(next);
                    }
                }
            }
        }
    }
}