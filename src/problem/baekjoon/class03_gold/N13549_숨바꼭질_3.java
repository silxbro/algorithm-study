package src.problem.baekjoon.class03_gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class N13549_숨바꼭질_3 {

    static int[] time;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        time = new int[100001];
        Arrays.fill(time, -1);

        bfs(N, K);

        System.out.println(time[K]);
    }

    private static void bfs(int start, int end) {
        time[start] = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        while (!queue.isEmpty()) {
            int now = queue.poll();
            if (now == end) {
                break;
            }
            if (now * 2 < time.length && time[now * 2] == -1) {
                time[now * 2] = time[now];
                queue.add(now * 2);
            }
            if (now - 1 >= 0 && time[now - 1] == -1) {
                time[now - 1] = time[now] + 1;
                queue.add(now - 1);
            }
            if (now + 1 < time.length && time[now + 1] == -1) {
                time[now + 1] = time[now] + 1;
                queue.add(now + 1);
            }
        }
    }
}