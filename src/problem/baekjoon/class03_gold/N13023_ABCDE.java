package src.problem.baekjoon.class03_gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class N13023_ABCDE {

    static int N, M;
    static List<Integer>[] relations;
    static boolean[] visited;
    static boolean existRelation;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        relations = new ArrayList[N];
        visited = new boolean[N];
        for (int i = 0; i < N; i++) {
            relations[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            relations[a].add(b);
            relations[b].add(a);
        }

        existRelation = false;
        for (int i = 0; i < N; i++) {
            dfs(i, 1);
            if (existRelation) {
                break;
            }
        }
        System.out.println(existRelation ? 1 : 0);
    }

    private static void dfs(int now, int count) {
        if (count == 5) {
            existRelation = true;
            return;
        }
        visited[now] = true;
        for (int next : relations[now]) {
            if (!visited[next]) {
                dfs(next, count + 1);
            }
        }
        visited[now] = false;
    }
}