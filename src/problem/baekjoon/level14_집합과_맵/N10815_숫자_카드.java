package src.problem.baekjoon.level14_집합과_맵;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

class N10815_숫자_카드 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        Set<Integer> cards = new HashSet<>();
        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            cards.add(Integer.parseInt(st.nextToken()));
        }

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        StringBuilder stb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            int contain = cards.contains(Integer.parseInt(st.nextToken())) ? 1 : 0;
            stb.append(contain).append(" ");
        }
        System.out.println(stb);
    }
}