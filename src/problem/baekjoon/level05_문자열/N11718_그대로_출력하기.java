package src.problem.baekjoon.level05_문자열;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class N11718_그대로_출력하기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String line;
        while ((line = br.readLine()) != null) {
            bw.write(line + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

}