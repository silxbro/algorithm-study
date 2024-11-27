package src.problem.baekjoon.class03_gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class N10942_팰린드롬 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        boolean[][] palindrome = new boolean[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            palindrome[i][i] = true;
            int s = i - 1;
            int e = i + 1;
            while (s >= 1 && e <= N) {
                if (arr[s] == arr[e]) {
                    palindrome[s][e] = true;
                    s--;
                    e++;
                } else {
                    break;
                }
            }
            s = i;
            e = i + 1;
            while (s >= 1 && e <= N) {
                if (arr[s] == arr[e]) {
                    palindrome[s][e] = true;
                    s--;
                    e++;
                } else {
                    break;
                }
            }
        }

        int M = Integer.parseInt(br.readLine());
        StringBuilder stb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            stb.append(palindrome[s][e] ? 1 : 0).append("\n");
        }

        System.out.println(stb);
    }
}