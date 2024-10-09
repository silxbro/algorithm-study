package src.problem.baekjoon.level32_최단_경로;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class N13549_숨바꼭질_3 {

    static int[] time;
    static int N, K;

    public static void main(String[] args) {
        time = new int[100001];
        Arrays.fill(time, -1);
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        K = scanner.nextInt();

        time[N] = 0;
        bfs(N);
        System.out.println(time[K]);
    }

    private static void bfs(int number) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(number);
        while(!queue.isEmpty()) {
            int now = queue.poll();
            int[] nextList = {now * 2, now - 1, now + 1};
            int[] dt = {0, 1, 1};
            for (int i = 0; i < 3; i++) {
                int next = nextList[i];
                if (next >= 0 && next <= 100000 && time[next] == -1) {
                    time[next] = time[now] + dt[i];
                    queue.add(next);
                    if (next == K) {
                        return;
                    }
                }
            }
        }
    }
}