package src.problem.baekjoon.class02_silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class N19941_햄버거_분배 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        String line = br.readLine();
        boolean[] visited = new boolean[N];

        int count = 0;
        for (int i = 0; i < line.length(); i++) {
            if (line.charAt(i) == 'P') {
                for (int j = i - K; j <= i + K; j++) {
                    if (j >= 0 && j < N && line.charAt(j) == 'H' && !visited[j]) {
                        visited[j] = true;
                        count++;
                        break;
                    }
                }
            }
        }

        System.out.println(count);
    }
}