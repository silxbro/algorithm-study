package src.problem.baekjoon.level13_정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class N2751_수_정렬하기_2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        boolean[] exist = new boolean[2000001];

        for (int i = 0; i < N; i++) {
            int number = Integer.parseInt(br.readLine());
            exist[number + 1000000] = true;
        }

        for (int i = 0; i < exist.length; i++) {
            if (exist[i]) {
                System.out.println(i - 1000000);
            }
        }
    }
}