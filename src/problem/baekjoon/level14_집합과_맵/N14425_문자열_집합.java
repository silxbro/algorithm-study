package src.problem.baekjoon.level14_집합과_맵;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

class N14425_문자열_집합 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Set<String> strings = new HashSet<>();
        for (int i = 0; i < N; i++) {
            strings.add(br.readLine());
        }
        int count = 0;
        for (int i = 0; i < M; i++) {
            if (strings.contains(br.readLine())) {
                count++;
            }
        }
        System.out.println(count);
    }
}