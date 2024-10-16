package src.problem.baekjoon.level36_유니온_파인드;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class N1976_여행_가자 {

    static int[] parent;
    static int[] cities;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        parent = new int[N + 1];
        cities = new int[M];
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                int link = Integer.parseInt(st.nextToken());
                if (link == 1) {
                    union(i, j);
                }
            }
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            cities[i] = Integer.parseInt(st.nextToken());
        }

        boolean canTravel = true;
        for (int i = 0; i < M - 1; i++) {
            if (!checkSame(cities[i], cities[i + 1])) {
                canTravel = false;
                break;
            }
        }
        System.out.println(canTravel ? "YES" : "NO");
    }

    private static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a != b) {
            parent[b] = a;
        }
    }

    private static boolean checkSame(int a, int b) {
        a = find(a);
        b = find(b);
        return a == b;
    }

    private static int find(int a) {
        if (a == parent[a]) {
            return a;
        }
        return parent[a] = find(parent[a]);
    }
}