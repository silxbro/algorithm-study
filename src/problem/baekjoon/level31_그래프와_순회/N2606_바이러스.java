package src.problem.baekjoon.level31_그래프와_순회;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class N2606_바이러스 {
    // 문제의 함정 주의하기

    static List<Integer>[] computers;
    static boolean[] visited;
    static int count = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        computers = new ArrayList[N + 1];
        visited = new boolean[N + 1];
        for (int i = 0; i < computers.length; i++) {
            computers[i] = new ArrayList<>();
        }

        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            computers[a].add(b);
            computers[b].add(a);
        }

        dfs(1);

        System.out.println(count);
    }

    private static void dfs(int number) {
        visited[number] = true;
        count++;
        for (int next : computers[number]) {
            if (!visited[next]) {
                dfs(next);
            }
        }
    }
}