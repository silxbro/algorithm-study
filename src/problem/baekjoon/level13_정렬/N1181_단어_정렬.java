package src.problem.baekjoon.level13_정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;

class N1181_단어_정렬 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Set<String> words = new TreeSet<>((o1, o2) -> {
            if (o1.length() == o2.length()) {
                return o1.compareTo(o2);
            }
            return o1.length() - o2.length();
        });

        for (int i = 0; i < N; i++) {
            words.add(br.readLine());
        }

        StringBuilder stb = new StringBuilder();
        for (String word : new ArrayList<>(words)) {
            stb.append(word).append("\n");
        }
        System.out.println(stb);
    }
}