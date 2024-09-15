package src.problem.baekjoon.level20_심화_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

class N26069_붙임성_좋은_총총이 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        Set<String> dancing = new HashSet<>();
        dancing.add("ChongChong");

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String first = st.nextToken();
            String second = st.nextToken();
            if (dancing.contains(first) || dancing.contains(second)) {
                dancing.add(first);
                dancing.add(second);
            }
        }
        System.out.println(dancing.size());
    }
}