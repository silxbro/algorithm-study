package src.problem.baekjoon.level16_스택_큐_덱;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

class N24511_queuestack {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        boolean[] isStack = new boolean[N];
        for (int i = 0; i < N; i++) {
            isStack[i] = Integer.parseInt(st.nextToken()) == 1;
        }

        st = new StringTokenizer(br.readLine());
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            int number = Integer.parseInt(st.nextToken());  // 버그 주의
            if (!isStack[i]) {
                deque.addFirst(number);
            }
        }

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            deque.addLast(Integer.parseInt(st.nextToken()));
        }

        StringBuilder stb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            stb.append(deque.pop()).append(" ");
        }
        System.out.println(stb);
    }
}