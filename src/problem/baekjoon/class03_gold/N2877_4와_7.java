package src.problem.baekjoon.class03_gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N2877_4와_7 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = Integer.toBinaryString(Integer.parseInt(br.readLine()) + 1)
            .replace('0', '4')
            .replace('1', '7');

        System.out.println(s.substring(1));
    }
}