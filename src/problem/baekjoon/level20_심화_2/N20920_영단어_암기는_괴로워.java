package src.problem.baekjoon.level20_심화_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

class N20920_영단어_암기는_괴로워 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<String, Integer> countMap = new HashMap<>();
        for (int i = 0; i < N; i++) {
            String word = br.readLine();
            if (word.length() >= M) {
                countMap.put(word, countMap.getOrDefault(word, 0) + 1);
            }
        }
        StringBuilder stb = new StringBuilder();
        countMap.entrySet().stream().map(entry -> new WordCount(entry.getKey(), entry.getValue()))
                .sorted().forEach(wordCount -> stb.append(wordCount.word).append("\n"));
        System.out.println(stb);
    }
}

class WordCount implements Comparable<WordCount> {
    String word;
    int count;

    WordCount(String word, int count) {
        this.word = word;
        this.count = count;
    }

    @Override
    public int compareTo(WordCount o) {
        if (this.count == o.count && this.word.length() == o.word.length()) {
            return this.word.compareTo(o.word);
        }
        if (this.count == o.count) {
            return o.word.length() - this.word.length();
        }
        return o.count - this.count;
    }
}