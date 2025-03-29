package src.problem.baekjoon.class02_silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class N5567_결혼식 {

    static int n, m;
    static List<Integer>[] list;
    static boolean[] visited;
    static boolean[] check;
    static int answer;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        list = new ArrayList[n + 1];
        visited = new boolean[n + 1];
        check = new boolean[n + 1];

        for (int i = 0; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            list[b].add(a);
        }

        dfs(1, 0);

        System.out.println(answer);
    }

    private static void dfs(int now, int count) {
        if (count > 2) {
            return;
        }
        if (count > 0 && !check[now]) {
            check[now] = true;
            answer++;
        }
        visited[now] = true;
        for (int next : list[now]) {
            if (!visited[next]) {
                dfs(next, count + 1);

            }
        }
        visited[now] = false;
    }
}