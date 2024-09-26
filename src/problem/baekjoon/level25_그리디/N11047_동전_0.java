package src.problem.baekjoon.level25_그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class N11047_동전_0 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(br.readLine());
        }

        int index = N - 1;
        int count = 0;
        while (K > 0) {
            // i ≥ 2인 경우에 Ai는 Ai-1의 배수이므로, 그리디 알고리즘 적용 가능
            count += K / A[index];
            K %= A[index];
            index--;
        }

        System.out.println(count);
    }
}