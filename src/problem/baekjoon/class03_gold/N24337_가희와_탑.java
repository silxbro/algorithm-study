package src.problem.baekjoon.class03_gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class N24337_가희와_탑 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        if (N < a + b) {
            System.out.println(-1);
            return;
        }

        List<Integer> list = new ArrayList<>();
        for (int i = 1; i < a + b - 1; i++) {
            list.add(i);
        }

        list.add(a - 1, a + b - 1);



        StringBuilder stb = new StringBuilder();
        while (!list.isEmpty()) {
            int num = list.remove(0);
            stb.append(num).append(" ");
            if (num == 1) {
                for (int i = 0; i <= N - a - b; i++) {
                    stb.append(num).append(" ");
                }
            }

        }
        System.out.println(stb);
    }
}
