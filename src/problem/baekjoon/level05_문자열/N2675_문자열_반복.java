package src.problem.baekjoon.level05_문자열;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class N2675_문자열_반복 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            int count = Integer.parseInt(st.nextToken());
            String target = st.nextToken();

            StringBuilder stb = new StringBuilder();
            for (int i = 0; i < target.length(); i++) {
                stb.append(String.valueOf(target.charAt(i)).repeat(count));
            }
            bw.write(stb + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
