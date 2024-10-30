package src.problem.baekjoon.class02_silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class N1244_스위치_켜고_끄기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        int[] switches = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            switches[i] = Integer.parseInt(st.nextToken());
        }

        int C = Integer.parseInt(br.readLine());
        for (int i = 0; i < C; i++) {
            st = new StringTokenizer(br.readLine());
            int g = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken()) - 1;
            if (g == 1) {
                for (int j = n; j < N; j += (n + 1)) {
                    switches[j] = Math.abs(switches[j] - 1);
                }

            } else {
                int a = n - 1;
                int b = n + 1;
                while (a >= 0 && b < N && switches[a] == switches[b]) {
                    a--;
                    b++;
                }
                while (a < b) {
                    a++;
                    b--;
                    int num = Math.abs(switches[a] - 1);
                    switches[a] = num;
                    switches[b] = num;
                }
            }
        }

        StringBuilder stb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            stb.append(switches[i]).append(" ");
            if (i % 20 == 19) {
                stb.append("\n");
            }
        }
        System.out.println(stb);
    }
}