package src.problem.baekjoon.level23_동적_계획법_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class N9184_신나는_함수_실행 {

    static int[][][] function;

    public static void main(String[] args) throws IOException {
        function = new int[21][21][21];   // 0 이하 또는 20 초과의 경우, 일정한 값이므로 기록할 필요 없음

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder stb = new StringBuilder();
        while (true) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if (a == -1 && b == -1 && c == -1) {
                break;
            }
            stb.append(String.format("w(%d, %d, %d) = %d", a, b, c, w(a, b, c))).append("\n");
        }

        System.out.println(stb);
    }

    private static int w(int a, int b, int c) {
        if (a <= 0 || b <= 0 || c <= 0) {
            return 1;
        }

        if (a > 20 || b > 20 || c > 20) {
            return function[20][20][20] = w(20, 20, 20);
        }

        if (function[a][b][c] != 0) {
            return function[a][b][c];
        }

        if (a < b && b < c) {
            return function[a][b][c] = w(a, b, c-1) + w(a, b-1, c-1) - w(a, b-1, c);
        }

        return function[a][b][c] = w(a-1, b, c) + w(a-1, b-1, c) + w(a-1, b, c-1) - w(a-1, b-1, c-1);
    }
}