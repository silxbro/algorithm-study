package src.problem.baekjoon.level22_백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class N14889_스타트와_링크 {

    static int[][] capability;
    static int N;
    static int minDiff;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        capability = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                capability[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        minDiff = Integer.MAX_VALUE;
        backtrack(0, new ArrayList<>());
        System.out.println(minDiff);
    }

    private static void backtrack(int number, List<Integer> numbers) {
        if (numbers.size() == N / 2) {
            int team1 = 0;
            int team2 = 0;
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j < i; j++) {
                    if (numbers.contains(i) && numbers.contains(j)) {
                        team1 += capability[i][j] + capability[j][i];
                    }
                    if (!numbers.contains(i) && !numbers.contains(j)) {
                        team2 += capability[i][j] + capability[j][i];
                    }
                }
            }
            minDiff = Math.min(minDiff, Math.abs(team1 - team2));
            return;
        }
        for (int i = number + 1; i <= N; i++) {
            List<Integer> list = new ArrayList<>(numbers);
            list.add(i);
            backtrack(i, list);
        }
    }
}