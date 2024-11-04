package src.problem.baekjoon.class02_silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class N20920_영단어_암기는_괴로워 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<String, Integer> countMap = new HashMap<>();
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            if (str.length() >= M) {
                countMap.put(str, countMap.getOrDefault(str, 0) + 1);
            }
        }

        PriorityQueue<String> queue = new PriorityQueue<>((o1, o2) -> {
            if (countMap.get(o1) == countMap.get(o2) && o1.length() == o2.length()) {
                return o1.compareTo(o2);
            }
            if (countMap.get(o1).equals(countMap.get(o2))) {
                return o2.length() - o1.length();
            }
            return countMap.get(o2) - countMap.get(o1);
        });

        queue.addAll(countMap.keySet());

        StringBuilder stb = new StringBuilder();
        while (!queue.isEmpty()) {
            stb.append(queue.poll()).append("\n");
        }

        System.out.println(stb);
    }
}