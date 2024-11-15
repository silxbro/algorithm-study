package src.problem.baekjoon.class03_gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class N2138_전구와_스위치 {

    static Set<String> visited; // 등장한 이력이 있는 문자열 기록
    static boolean[] from, to;
    static long answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String fromStr = br.readLine();
        String toStr = br.readLine();
        from = new boolean[N];
        to = new boolean[N];
        visited = new HashSet<>();

        for (int i = 0; i < N; i++) {
            from[i] = fromStr.charAt(i) == '1';
            to[i] = toStr.charAt(i) == '1';
        }

        answer = -1;

        dfs(to, 0);

        System.out.println(answer);
    }

    private static void dfs(boolean[] now, int count) {
        if (Arrays.equals(now, from)) {
            answer = count;
            return;
        }
        visited.add(Arrays.toString(now));
        for (int i = 0; i < now.length; i++) {
            now[i] = !now[i];
            if (i - 1 >= 0) {
                now[i - 1] = !now[i - 1];
            }
            if (i + 1 < now.length) {
                now[i + 1] = !now[i + 1];
            }
            if (!visited.contains(Arrays.toString(now))) {
                dfs(now, count + 1);
            }
            now[i] = !now[i];
            if (i - 1 >= 0) {
                now[i - 1] = !now[i - 1];
            }
            if (i + 1 < now.length) {
                now[i + 1] = !now[i + 1];
            }
        }
    }
}
