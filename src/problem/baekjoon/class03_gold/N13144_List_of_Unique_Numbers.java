package src.problem.baekjoon.class03_gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class N13144_List_of_Unique_Numbers {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        boolean[] visited = new boolean[100001];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        long answer = 0;
        int s = 0;
        int e = 0;
        while (s <= e && e < N) {
            if (visited[arr[e]]) {
                while (arr[s] != arr[e]) {
                    visited[arr[s]] = false;
                    s++;
                }
                visited[arr[s]] = false;
                s++;
            } else {
                visited[arr[e]] = true;
                answer += e - s + 1;
                e++;
            }
        }

        System.out.println(answer);
    }
}