package src.problem.baekjoon.class03_gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class N17140_이차원_배열과_연산 {
    static int[][] map = new int[100][100];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int r = Integer.parseInt(st.nextToken()) - 1;
        int c = Integer.parseInt(st.nextToken()) - 1;
        int k = Integer.parseInt(st.nextToken());

        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int rows = 3;
        int cols = 3;
        int answer = -1;
        for (int t = 0; t <= 100; t++) {
            if (map[r][c] == k) {
                answer = t;
                break;
            }
            if (rows >= cols) {
                cols = operation(rows, cols);
            } else {
                swap(rows);
                rows = operation(cols, rows);
                swap(cols);
            }
        }

        System.out.println(answer);
    }

    private static void swap(int rows) {
        for (int r = 0; r < 100; r++) {
            for (int c = 0; c < r; c++) {
                int temp = map[r][c];
                map[r][c] = map[c][r];
                map[c][r] = temp;
            }
        }
    }
    private static int operation(int rows, int cols) {
        int maxLines = 0;
        Map<Integer, Integer> countMap;

        for (int r = 0; r < rows; r++) {
            countMap = new HashMap<>();
            for (int c = 0; c < cols; c++) {
                if (map[r][c] != 0) {
                    countMap.put(map[r][c], countMap.getOrDefault(map[r][c], 0) + 1);
                    map[r][c] = 0;
                }
            }
            PriorityQueue<Count> queue = new PriorityQueue<>();
            for (int num : countMap.keySet()) {
                if (queue.size() == 50) {
                    break;
                }
                queue.add(new Count(num, countMap.get(num)));
            }
            maxLines = Math.max(maxLines, queue.size() * 2);
            int index = 0;
            while (!queue.isEmpty()) {
                Count now = queue.poll();
                map[r][index] = now.num;
                map[r][index + 1] = now.value;
                index += 2;
            }
        }
        return maxLines;
    }
}

class Count implements Comparable<Count>{
    int num;
    int value;

    Count(int num, int value) {
        this.num = num;
        this.value = value;
    }

    @Override
    public int compareTo(Count o) {
        if (value == o.value) {
            return num - o.num;
        }
        return value - o.value;
    }
}