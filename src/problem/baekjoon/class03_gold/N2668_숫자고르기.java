package src.problem.baekjoon.class03_gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class N2668_숫자고르기 {
    static int[] arr;
    static boolean[] visited;
    static List<Integer> answer;
    static boolean right;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        arr = new int[N + 1];
        visited = new boolean[N + 1];
        answer = new ArrayList<>();

        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                right = true;
                dfs(i, i);
            }
        }

        StringBuilder stb = new StringBuilder();

        Collections.sort(answer);
        stb.append(answer.size()).append("\n");
        for (int i = 0; i < answer.size(); i++) {
            stb.append(answer.get(i)).append("\n");
        }

        System.out.println(stb);
    }

    private static void dfs(int index, int firstIndex) {
        visited[index] = true;
        answer.add(index);
        if (visited[arr[index]]) {
            if (arr[index] != firstIndex) {
                right = false;
                visited[index] = false;
                answer.remove(answer.size() - 1);
            }
            return;
        }
        dfs(arr[index], firstIndex);
        if (!right) {
            visited[index] = false;
            answer.remove(answer.size() - 1);
        }
    }
}