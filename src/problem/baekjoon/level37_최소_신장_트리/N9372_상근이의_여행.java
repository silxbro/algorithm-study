package src.problem.baekjoon.level37_최소_신장_트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class N9372_상근이의_여행 {

    static int[][] edges;
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        StringBuilder stb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            parent = new int[N + 1];
            for (int i = 1; i <= N; i++) {
                parent[i] = i;
            }

            edges = new int[M][2];
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                edges[i][0] = Integer.parseInt(st.nextToken());
                edges[i][1] = Integer.parseInt(st.nextToken());
            }

            stb.append(N - 1).append("\n");
        }
        System.out.println(stb);
    }
}
