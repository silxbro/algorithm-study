package src.problem.baekjoon.level32_최단_경로;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class N11657_타임머신 {

    static Edge[] busInfo;
    static long[] distance;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        busInfo = new Edge[M];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            busInfo[i] = new Edge(s, e, v);
        }
        distance = new long[N + 1];
        Arrays.fill(distance, Long.MAX_VALUE);

        distance[1] = 0;
        for (int i = 0; i < N - 1; i++) {
            for (Edge edge : busInfo) {
                int s = edge.start;
                int e = edge.end;
                int v = edge.distance;
                if (distance[s] != Long.MAX_VALUE && distance[e] > distance[s] + v) {
                    distance[e] = distance[s] + v;
                }
            }
        }

        boolean cycle = false;
        for (Edge edge : busInfo) {
            int s = edge.start;
            int e = edge.end;
            int v = edge.distance;
            if (distance[s] != Long.MAX_VALUE && distance[e] > distance[s] + v) {
                System.out.println(-1);
                return;
            }
        }

        StringBuilder stb = new StringBuilder();
        for (int i = 2; i <= N; i++) {
            stb.append(distance[i] == Long.MAX_VALUE ? -1 : distance[i]).append("\n");
        }

        System.out.println(stb);
    }
}

class Edge {
    int start;
    int end;
    int distance;

    Edge(int start, int end, int distance) {
        this.start = start;
        this.end = end;
        this.distance = distance;
    }
}