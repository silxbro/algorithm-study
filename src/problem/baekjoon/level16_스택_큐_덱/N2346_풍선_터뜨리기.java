package src.problem.baekjoon.level16_스택_큐_덱;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class N2346_풍선_터뜨리기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] moveNumber = new int[N + 1];
        Queue<Integer> queue = new LinkedList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            moveNumber[i] = Integer.parseInt(st.nextToken());
            queue.add(i);
        }

        StringBuilder stb = new StringBuilder();
        int move = 0;
        while(queue.size() > 1) {
            for (int i = 0; i < move - 1; i++) {
                queue.add(queue.poll());
            }

            int now = queue.poll();
            stb.append(now).append(" ");

            move = moveNumber[now];
            if (move <= 0) {
                move++;
                while (move <= 0) {
                    move += queue.size();
                }
            }
        }
        stb.append(queue.poll());
        System.out.println(stb);
    }
}