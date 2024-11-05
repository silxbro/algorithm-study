package src.problem.baekjoon.class02_silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class N2075_N번째_큰_수 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[][] map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        PriorityQueue<Integer> queue = new PriorityQueue<>(N);
        for (int i = 0; i < N; i++) {
            queue.add(map[i][0]);
        }

        for (int i = 1; i < N; i++) {
            for (int j = N - 1; j >= 0; j--) {
                if (queue.peek() > map[j][i]) {
                    break;
                }
                queue.poll();
                queue.add(map[j][i]);
            }
        }

        System.out.println(queue.poll());
    }
}