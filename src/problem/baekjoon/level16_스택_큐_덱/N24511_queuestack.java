package src.problem.baekjoon.level16_스택_큐_덱;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

class N24511_queuestack {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        List<List<Integer>> queuestack = new ArrayList<>();
        int N = Integer.parseInt(br.readLine());
        boolean[] isStack = new boolean[N + 1];
        st = new StringTokenizer(br.readLine());
        queuestack.add(0, new LinkedList<>());
        for (int i = 1; i <= N; i++) {
            int stackOrQueue = Integer.parseInt(st.nextToken());
            isStack[i] = stackOrQueue == 1;
            queuestack.add(i, new LinkedList<>());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            int number = Integer.parseInt(st.nextToken());
            queuestack.get(i).add(number);
        }

        int M = Integer.parseInt(br.readLine());
        StringBuilder stb = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int number = Integer.parseInt(st.nextToken());
            for (int j = 1; j < N; j++) {
                if (isStack[j]) {
                    queuestack.get(j).addFirst(number);
                } else {
                    queuestack.get(j).addLast(number);
                }

                int pop = queuestack.get(j).removeFirst();
                if (isStack[j + 1]) {
                    queuestack.get(j + 1).addFirst(pop);
                } else {
                    queuestack.get(j + 1).addLast(pop);
                }
            }
            stb.append(queuestack.get(N).removeFirst()).append(" ");
        }
        System.out.println(stb);
    }
}