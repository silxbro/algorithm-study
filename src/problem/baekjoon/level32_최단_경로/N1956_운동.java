package src.problem.baekjoon.level32_최단_경로;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class N1956_운동 {

    final static long INF = 400L * 400 * 2 * 10000;
    static long[][] path;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        path = new long[V + 1][V + 1];
        for (int i = 1; i <= V; i++) {
            for (int j = 1; j <= V; j++) {
                path[i][j] = INF;
            }
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            path[s][e] = v;
        }

        for (int k = 1; k <= V; k++) {
            for (int s = 1; s <= V; s++) {
                for (int e = 1; e <= V; e++) {
                    path[s][e] = Math.min(path[s][e], path[s][k] + path[k][e]);
                }
            }
        }

        long answer = INF;
        for (int i = 1; i <= V; i++) {
            answer = Math.min(answer, path[i][i]);
        }

        if (answer == INF) {
            System.out.println(-1);
        } else {
            System.out.println(answer);
        }
    }
}