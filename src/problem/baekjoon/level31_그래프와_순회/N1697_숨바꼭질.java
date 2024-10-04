package src.problem.baekjoon.level31_그래프와_순회;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class N1697_숨바꼭질 {

    static int[] D;

    public static void main(String[] args) {
        D = new int[100001];
        Arrays.fill(D, -1);

        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int K = scanner.nextInt();

        dfs(N);

        System.out.println(D[K]);
    }

    private static void dfs(int number) {
        Queue<Integer> queue = new LinkedList<>();
        D[number] = 0;
        queue.add(number);
        while (!queue.isEmpty()) {
            int now = queue.poll();
            int[] nextList = {now - 1, now + 1, now * 2};
            for (int next : nextList) {
                if (next >= 0 && next < D.length && D[next] == -1) {
                    D[next] = D[now] + 1;
                    queue.add(next);
                }
            }
        }
    }
}