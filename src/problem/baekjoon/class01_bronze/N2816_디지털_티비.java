package src.problem.baekjoon.class01_bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class N2816_디지털_티비 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder stb = new StringBuilder();
        int kbs1Pointer = 0;
        int kbs2Pointer = 0;

        for (int i = 0; i < N; i++) {
            String channel = br.readLine();
            if (channel.equals("KBS1")) {
                kbs1Pointer = i;
            }
            if (channel.equals("KBS2")) {
                kbs2Pointer = i;
            }
        }

        int pointer;
        if (kbs1Pointer > kbs2Pointer) {
            kbs2Pointer++;
        }
        for (pointer = 0; pointer < kbs1Pointer; pointer++) {
            stb.append('1');
        }
        for (pointer = kbs1Pointer; pointer > 0; pointer--) {
            stb.append('4');
        }
        for (pointer = 0; pointer < kbs2Pointer; pointer++) {
            stb.append('1');
        }
        for (pointer = kbs2Pointer; pointer > 1; pointer--) {
            stb.append('4');
        }

        System.out.println(stb);
    }
}