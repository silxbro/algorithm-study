package src.problem.baekjoon.level34_동적_계획법과_최단거리_역추적;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

class N11780_플로이드_2 {

    static long[][] cost;
    static int[][] parent;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        cost = new long[n + 1][n + 1];
        parent = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                parent[i][j] = j;
                if (i != j) {
                    cost[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            cost[s][e] = Math.min(cost[s][e], c);
            parent[s][e] = s;
        }

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (cost[i][j] > cost[i][k] + cost[k][j]) {
                        cost[i][j] = cost[i][k] + cost[k][j];
                        parent[i][j] = parent[k][j];
                    }
                }
            }
        }

        StringBuilder stb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                stb.append(cost[i][j] == Integer.MAX_VALUE ? 0 : cost[i][j]).append(" ");
            }
            stb.append("\n");
        }

        Stack<Integer> cities;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (cost[i][j] == 0 || cost[i][j] == Integer.MAX_VALUE) {
                    stb.append(0);
                } else {
                    cities = new Stack<>();
                    int city = j;
                    while(city != i) {
                        cities.push(city);
                        city = parent[i][city];
                    }
                    cities.push(city);
                    stb.append(cities.size()).append(" ");
                    while (!cities.isEmpty()) {
                        stb.append(cities.pop()).append(" ");
                    }
                }
                stb.append("\n");
            }
        }
        System.out.println(stb);
    }
}