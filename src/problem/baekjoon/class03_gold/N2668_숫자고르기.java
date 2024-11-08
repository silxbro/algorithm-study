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
                List<Integer> tempList = new ArrayList<>();
                if (dfs(i, i, tempList)) {
                    answer.addAll(tempList);
                }
            }
        }

        Collections.sort(answer);
        StringBuilder stb = new StringBuilder();
        stb.append(answer.size()).append("\n");
        for (int num : answer) {
            stb.append(num).append("\n");
        }
        System.out.println(stb);
    }

    private static boolean dfs(int current, int start, List<Integer> tempList) {
        if (visited[current]) {
            return current == start;  // 시작점으로 돌아왔으면 true, 아니면 false
        }

        visited[current] = true;
        tempList.add(current);

        if (dfs(arr[current], start, tempList)) {
            return true;
        }

        // 돌아온 경로가 올바르지 않은 경우 방문 표시 및 임시 리스트에서 제거
        visited[current] = false;
        tempList.remove(tempList.size() - 1);
        return false;
    }
}
