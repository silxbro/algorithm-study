package src.problem.baekjoon.class02_silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

class N22233_가희와_키워드 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Set<String> words = new HashSet<>();
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            words.add(str);
        }

        StringBuilder stb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            String[] targets = br.readLine().split(",");
            for (String target : targets) {
                words.remove(target);
            }
            stb.append(words.size()).append("\n");
        }
        System.out.println(stb);
    }
}