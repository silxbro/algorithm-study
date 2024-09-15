package src.problem.baekjoon.level20_심화_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class N1037_약수 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        long realCount = Integer.parseInt(br.readLine());
        long min = Long.MAX_VALUE;
        long max = Long.MIN_VALUE;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < realCount; i++) {
            long num = Long.parseLong(st.nextToken());
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        System.out.println(min * max);
    }
}