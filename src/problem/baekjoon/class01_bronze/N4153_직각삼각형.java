package src.problem.baekjoon.class01_bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N4153_직각삼각형 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder stb = new StringBuilder();

        while (true) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if (a == 0 && b == 0 && c == 0) {
                break;
            }
            stb.append(rightTriangle(a, b, c) ? "right" : "wrong").append("\n");
        }
        System.out.println(stb);
    }

    private static boolean rightTriangle(int a, int b, int c) {
        if (a > b && a > c) {
            return Math.pow(a, 2) == Math.pow(b, 2) + Math.pow(c, 2);
        }
        if (b > a && b > c) {
            return Math.pow(b, 2) == Math.pow(a, 2) + Math.pow(c, 2);
        }
        if (c > a && c > b) {
            return Math.pow(c, 2) == Math.pow(a, 2) + Math.pow(b, 2);
        }
        return false;
    }
}