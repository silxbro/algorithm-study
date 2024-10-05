package src.problem.baekjoon.level31_그래프와_순회;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class N16928_뱀과_사다리_게임 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] board = new int[101];
        int[] move = new int[101];

        for (int i = 0; i < N + M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            move[a] = b;
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);

        while (true) {
            int now = queue.poll();
            for (int i = 1; i <= 6; i++) {
                int next = now + i;
                if (next >= 1 && next <= 100) {
                    if (move[next] != 0) {
                        next = move[next];
                    }
                    if (board[next] == 0) {
                        board[next] = board[now] + 1;
                        queue.add(next);
                    }
                    if (next == 100) {
                        break;
                    }
                }
            }
            if (board[100] != 0) {
                break;
            }
        }
        System.out.println(board[100]);
    }
}