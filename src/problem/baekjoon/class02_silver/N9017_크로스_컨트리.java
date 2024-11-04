package src.problem.baekjoon.class02_silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

class N9017_크로스_컨트리 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int[] count;
        int[] order;
        int[] scores;

        int T = Integer.parseInt(br.readLine());
        StringBuilder stb = new StringBuilder();

        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            count = new int[201]; // 선수의 수 카운트 배열
            order = new int[N]; // 완주 팀 순서 배열
            scores = new int[201];

            st = new StringTokenizer(br.readLine());
            Set<Integer> notEnough = new HashSet<>();
            for (int i = 0; i < N; i++) {
                order[i] = Integer.parseInt(st.nextToken());
                count[order[i]]++;
                if (count[order[i]] == 1) {
                    notEnough.add(order[i]);
                }
                if (count[order[i]] == 6) {
                    notEnough.remove(order[i]);
                }
            }

            int score = 0;
            count = new int[201];
            int min = 0;
            scores[min] = Integer.MAX_VALUE;
            int fifth = Integer.MAX_VALUE;
            for (int i = 0; i < N; i++) {
                if (!notEnough.contains(order[i])) {
                    count[order[i]]++;
                    score++;
                    if (count[order[i]] <= 4) {
                        scores[order[i]] += score;
                    }
                    if (count[order[i]] == 5) {
                        if (scores[min] > scores[order[i]] || scores[min] == scores[order[i]] && score < fifth) {
                            min = order[i];
                            fifth = score;
                        }
                    }
                }
            }
            stb.append(min).append("\n");
        }

        System.out.println(stb);
    }
}