package src.problem.baekjoon.level24_누적_합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class N2559_수열 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] temp = new int[N];
        int index = 0;
        int sum = 0;
        st = new StringTokenizer(br.readLine());

        while (index < K) {
            int now = Integer.parseInt(st.nextToken());
            sum += now;
            temp[index] = now;
            index++;
        }
        int maxTemp = sum;
        while (index < N) {
            int now = Integer.parseInt(st.nextToken());
            sum += now - temp[index - K];
            temp[index] = now;
            maxTemp = Math.max(maxTemp, sum);
            index++;
        }
        System.out.println(maxTemp);
    }
}