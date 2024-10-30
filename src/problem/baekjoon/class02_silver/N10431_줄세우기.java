package src.problem.baekjoon.class02_silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class N10431_줄세우기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder stb = new StringBuilder();

        int P = Integer.parseInt(br.readLine());
        for (int i = 0; i < P; i++) {
            st = new StringTokenizer(br.readLine());
            stb.append(st.nextToken()).append(" ");

            int[] line = new int[20];
            long count = 0;
            for (int j = 0; j < 20; j++) {
                int height = Integer.parseInt(st.nextToken());
                int position = j;
                for (int p = j - 1; p >= 0; p--) {
                    if (line[p] > height) {
                        position = p;
                    }
                }
                if (position < j) {
                    for (int p = j - 1; p >= position; p--) {
                        line[p + 1] = line[p];
                        count++;
                    }
                }
                line[position] = height;
            }
            stb.append(count).append("\n");
        }

        System.out.println(stb);
    }
}