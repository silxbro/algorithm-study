package src.problem.baekjoon.class03_gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class N7662_이중_우선순위_큐 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder stb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            TreeMap<Integer, Integer> map = new TreeMap<>();
            int k = Integer.parseInt(br.readLine());
            for (int i = 0; i < k; i++) {
                st = new StringTokenizer(br.readLine());
                String command = st.nextToken();
                int num = Integer.parseInt(st.nextToken());
                if (command.equals("I")) {
                    map.put(num, map.getOrDefault(num, 0) + 1);
                } else if (num == -1 && !map.isEmpty()) {
                    int firstKey = map.firstKey();
                    int count = map.get(firstKey);
                    if (count == 1) {
                        map.pollFirstEntry();
                    } else {
                        map.put(firstKey, count - 1);
                    }
                } else if (num == 1 && !map.isEmpty()) {
                    int lastKey = map.lastKey();
                    int count = map.get(lastKey);
                    if (count == 1) {
                        map.pollLastEntry();
                    } else {
                        map.put(lastKey, count - 1);
                    }
                }
            }

            stb.append(map.isEmpty() ? "EMPTY" : map.lastKey() + " " + map.firstKey()).append("\n");

        }
        System.out.println(stb);
    }
}