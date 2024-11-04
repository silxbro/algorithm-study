package src.problem.baekjoon.class02_silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class N20310_타노스 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        int[] order = new int[str.length()];

        int one = 0;
        int zero = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '1') {
                order[i] = ++one;
            } else {
                order[i] = ++zero;
            }
        }

        StringBuilder stb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == '1' && order[i] > one / 2) {
                stb.append(c);
            } else if (c == '0' && order[i] <= zero / 2) {
                stb.append(c);
            }
        }
        System.out.println(stb);
    }
}