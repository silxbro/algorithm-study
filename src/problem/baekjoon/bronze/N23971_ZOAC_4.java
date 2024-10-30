package src.problem.baekjoon.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class N23971_ZOAC_4 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        System.out.println(getLineCount(H, N) * getLineCount(W, M));
    }

    private static int getLineCount(int line, int interval) {
        if (line % (interval + 1) == 0) {
            return line / (interval + 1);
        }
        return line / (interval + 1) + 1;
    }
}