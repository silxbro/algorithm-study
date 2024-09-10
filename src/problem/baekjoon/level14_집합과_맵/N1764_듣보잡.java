package src.problem.baekjoon.level14_집합과_맵;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

class N1764_듣보잡 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Set<String> neverHeardOf = new HashSet<>();
        for (int i = 0; i < N; i++) {
            neverHeardOf.add(br.readLine());
        }

        Set<String> bothNever = new TreeSet<>();
        for (int i = 0; i < M; i++) {
            String name = br.readLine();
            if (neverHeardOf.contains(name)) {
                bothNever.add(name);
            }
        }

        StringBuilder stb = new StringBuilder();
        stb.append(bothNever.size()).append("\n");
        for (String name : bothNever) {
            stb.append(name).append("\n");
        }

        System.out.println(stb);
    }
}