package src.problem.baekjoon.class03_gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class N20437_문자열_게임_2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder stb = new StringBuilder();

        for (int t = 0; t < T; t++) {
            int min = 10000;
            int max = 0;
            String str = br.readLine();
            int K = Integer.parseInt(br.readLine());

            Queue<Character> queue = new LinkedList<>();
            for (char c = 'a'; c <= 'z'; c++) {
                int count = 0;
                queue.clear();
                for (int i = 0; i < str.length(); i++) {
                    while (!queue.isEmpty()) {
                        char remove = queue.peek();
                        if (remove == c) {
                            break;
                        }
                        queue.poll();
                    }
                    char now = str.charAt(i);
                    queue.add(now);
                    if (now == c) {
                        count++;
                        if (count == K) {
                            min = Math.min(min, queue.size());
                            max = Math.max(max, queue.size());
                            queue.poll();
                            count--;
                        }
                    }
                }
            }
            if (max == 0) {
                stb.append(-1);
            } else {
                stb.append(min + " " + max);
            }
            stb.append("\n");
        }
        System.out.println(stb);
    }
}