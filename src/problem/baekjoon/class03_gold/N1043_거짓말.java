package src.problem.baekjoon.class03_gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N1043_거짓말 {

    static int N, M;
    static int[] firstPerson;
    static int[] truth;
    static int[] parent;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        firstPerson = new int[M];
        parent = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        truth = new int[T];
        for (int t = 0; t < T; t++) {
            truth[t] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int P = Integer.parseInt(st.nextToken());
            int first = firstPerson[i] = Integer.parseInt(st.nextToken());

            for (int j = 0; j < P - 1; j++) {
                int now = Integer.parseInt(st.nextToken());
                union(first, now);
            }
        }

        int count = 0;
        for (int i = 0; i < M; i++) {
            boolean canLie = true;
            int first = firstPerson[i];
            for (int j = 0; j < T; j++) {
                if (find(first) == find(truth[j])) {
                    canLie = false;
                    break;
                }
            }
            if (canLie) count++;
        }

        System.out.println(count);
    }

    private static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a != b) {
            parent[b] = a;
        }
    }

    private static int find(int a) {
        if (a == parent[a]) {
            return a;
        }
        return parent[a] = find(parent[a]);
    }
}