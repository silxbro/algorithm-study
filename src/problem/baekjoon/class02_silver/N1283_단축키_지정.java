package src.problem.baekjoon.class02_silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class N1283_단축키_지정 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringBuilder stb = new StringBuilder();
        boolean[] visited = new boolean[26];

        for (int i = 0; i < N; i++) {
            String[] words = br.readLine().split(" ");
            boolean check = false;
            for (int j = 0; j < words.length; j++) {
                char c = words[j].toUpperCase().charAt(0);
                if (!visited[c - 'A']) {
                    visited[c - 'A'] = true;
                    words[j] = "[" + words[j].charAt(0) + "]" + words[j].substring(1);
                    check = true;
                    break;
                }
            }
            if (!check) {
                for (int j = 0; j < words.length; j++) {
                    for (int k = 0; k < words[j].length(); k++) {
                        char c = words[j].toUpperCase().charAt(k);
                        if (!visited[c - 'A']) {
                            visited[c - 'A'] = true;
                            words[j] = words[j].substring(0, k) + "[" + words[j].charAt(k) + "]" + words[j].substring(k + 1);
                            check = true;
                            break;
                        }
                    }
                    if (check) {
                        break;
                    }
                }
            }

            for (String word : words) {
                stb.append(word).append(" ");
            }
            stb.append("\n");
        }
        System.out.println(stb);
    }
}