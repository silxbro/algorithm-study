package src.problem.baekjoon.level36_유니온_파인드;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

class N4195_친구_네트워크 {

    static Map<String, Integer> matches;
    static int[] parent;
    static int[] count;
    static int index;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        StringBuilder stb = new StringBuilder();

        for (int t = 0; t < T; t++) {
            parent = new int[200000];
            count = new int[200000];
            matches = new HashMap<>();
            index = 0;

            int F = Integer.parseInt(br.readLine());
            for (int f = 0; f < F; f++) {
                st = new StringTokenizer(br.readLine());

                int a = getNumber(st.nextToken());
                int b = getNumber(st.nextToken());

                union(a, b);

                stb.append(count[find(a)]).append("\n");
            }
        }
        System.out.println(stb);
    }

    private static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a != b) {
            parent[b] = a;
            count[a] += count[b];
        }
    }

    private static int find(int a) {
        if (a == parent[a]) {
            return a;
        }
        updateCount(a);
        return parent[a] = find(parent[a]);
    }

    private static int updateCount(int a) {
        if (a == parent[a]) {
            return count[a];
        }
        return count[a] = updateCount(parent[a]);
    }

    private static int getNumber(String name) {
        if (matches.containsKey(name)) {
            return matches.get(name);
        }
        parent[index] = index;
        count[index] = 1;
        matches.put(name, index++);
        return index - 1;
    }
}