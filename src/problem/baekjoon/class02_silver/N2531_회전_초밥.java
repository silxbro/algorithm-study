package src.problem.baekjoon.class02_silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class N2531_회전_초밥 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        int[] count = new int[d + 1];
        int kind = 0;
        int max = 0;
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            int dish = Integer.parseInt(br.readLine());
            arr[i] = dish;
            if (queue.size() == k) {
                int removed = queue.poll();
                count[removed]--;
                if (count[removed] == 0) {
                    kind--;
                }
            }
            queue.add(dish);
            count[dish]++;
            if (count[dish] == 1) {
                kind++;
            }
            if (queue.size() == k && count[c] == 0) {
                max = Math.max(max, kind + 1);
            }
            max = Math.max(max, kind);
        }

        for (int i = 0; i < k - 1; i++) {
            int dish = arr[i];
            int removed = queue.poll();
            count[removed]--;
            if (count[removed] == 0) {
                kind--;
            }
            queue.add(dish);
            count[dish]++;
            if (count[dish] == 1) {
                kind++;
            }
            if (queue.size() == k && count[c] == 0) {
                max = Math.max(max, kind + 1);
            }
            max = Math.max(max, kind);
        }
        System.out.println(max);
    }
}