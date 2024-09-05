package src.problem.baekjoon.level06_심화_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class N1316_그룹_단어_체커 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = 0;

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            String word = br.readLine();
            boolean[] check = new boolean[26];
            boolean isGroupWord = true;

            check[word.charAt(0) - 'a'] = true;
            Character before = word.charAt(0);

            for (int j = 1; j < word.length(); j++) {
                Character now = word.charAt(j);
                if (now != before && check[now - 'a']) {
                    isGroupWord = false;
                    break;
                }
                check[now - 'a'] = true;
                before = now;
            }
            if (isGroupWord) {
                count++;
            }
        }
        System.out.println(count);
    }
}