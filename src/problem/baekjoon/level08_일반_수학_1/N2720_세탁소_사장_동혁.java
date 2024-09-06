package src.problem.baekjoon.level08_일반_수학_1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class N2720_세탁소_사장_동혁 {

    static int[] coin = {25, 10, 5, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            long C = Long.parseLong(br.readLine());

            for (int i = 0; i < coin.length; i++) {
                bw.write(C / coin[i] + " ");
                C %= coin[i];
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}