package src.problem.baekjoon.class03_gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class N10282_해킹 {

    static List<Inf>[] infInfo;
    static boolean[] visited;
    static int[] time;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder stb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            infInfo = new ArrayList[n + 1];
            visited = new boolean[n + 1];
            time = new int[n + 1];
            Arrays.fill(time, Integer.MAX_VALUE);
            for (int i = 0; i <= n; i++) {
                infInfo[i] = new ArrayList<>();
            }

            for (int i = 0; i < d; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int s = Integer.parseInt(st.nextToken());
                infInfo[b].add(new Inf(a, s));
            }

            infect(c);

            int count = 0;
            int maxTime = 0;

            for (int i = 1; i <= n; i++) {
                if (visited[i]) {
                    count++;
                    maxTime = Math.max(maxTime, time[i]);
                }
            }

            stb.append(count).append(" ").append(maxTime).append("\n");
        }

        System.out.println(stb);
    }

    private static void infect(int start) {
        PriorityQueue<Inf> queue = new PriorityQueue<>();
        queue.add(new Inf(start, 0));
        time[start] = 0;
        while (!queue.isEmpty()) {
            Inf now = queue.poll();
            if (visited[now.com]) continue;
            visited[now.com] = true;
            for (Inf next : infInfo[now.com]) {
                if (time[next.com] >= now.time + next.time) {
                    time[next.com] = now.time + next.time;
                    queue.add(new Inf(next.com, time[next.com]));
                }
            }
        }
    }
}

class Inf implements Comparable<Inf> {
    int com;
    int time;

    public Inf(int com, int time) {
        this.com = com;
        this.time = time;
    }

    @Override
    public int compareTo(Inf o) {
        return time - o.time;
    }
}