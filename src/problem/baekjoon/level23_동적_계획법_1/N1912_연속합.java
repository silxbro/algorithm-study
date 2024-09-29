package src.problem.baekjoon.level23_동적_계획법_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class N1912_연속합 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] maxSum = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        maxSum[0] = Integer.parseInt(st.nextToken());
        int answer = maxSum[0]; // 한 개 이상의 수를 선택해야 하므로, 무조건 더해주기 (실수주의)

        for (int i = 1; i < maxSum.length; i++) {
            int now = Integer.parseInt(st.nextToken());
            // 이전까지의 최대 합이 음수일 경우, 리셋 후 현재 수부터 다시 시작
            maxSum[i] = maxSum[i - 1] < 0 ? now : maxSum[i - 1] + now;
            answer = Math.max(answer, maxSum[i]);
        }

        System.out.println(answer);

    }
}