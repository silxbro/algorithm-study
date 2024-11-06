package src.problem.baekjoon.class02_silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class N20922_겹치는_건_싫어 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int maxLen = 0;
        int[] count = new int[100001];
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (count[num] == K) {
                while (true) {
                    int now = queue.poll();
                    count[now]--;
                    if (now == num) {
                        break;
                    }
                }
            }
            queue.add(num);
            count[num]++;
            maxLen = Math.max(maxLen, queue.size());
        }
        System.out.println(maxLen);
    }
}