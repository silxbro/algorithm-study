package src.problem.baekjoon.level09_약수_배수와_소수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class N1978_소수_찾기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        boolean[] check = new boolean[1001];
        check[1] = true;
        for (int i = 2; i <= 500; i++) {
            for (int j = 2; j * i <= 1000; j++) {
                check[i * j] = true;
            }
        }

        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int count = 0;

        for (int i = 0; i < N; i++) {
            int target = Integer.parseInt(st.nextToken());
            if (!check[target]) {
                count++;
            }
        }
        System.out.println(count);
    }
}