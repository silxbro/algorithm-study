package src.problem.baekjoon.level10_기하_직사각형과_삼각형;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class N5073_삼각형과_세_변 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if (a == 0 && b == 0 && c == 0) {
                break;
            }

            int max = Math.max(a, Math.max(b, c));
            int sum = a + b + c;
            if (max * 2 >= sum) {
                System.out.println("Invalid");
                continue;
            }
            if (a == b && b == c) {
                System.out.println("Equilateral");
                continue;
            }
            if (a == b || b == c || a == c) {
                System.out.println("Isosceles");
                continue;
            }
            System.out.println("Scalene");
        }
    }
}