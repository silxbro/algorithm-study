package src.problem.baekjoon.class03_gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

class N15686_치킨_배달 {

    static int N, M;
    static List<int[]> stores;
    static List<int[]> houses;
    static Dist[][] dists;
    static int[] result;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        stores = new ArrayList<>();
        houses = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                int num = Integer.parseInt(st.nextToken());
                if (num == 1) {
                    houses.add(new int[]{i, j});
                }
                if (num == 2) {
                    stores.add(new int[]{i, j});
                }
            }
        }

        dists = new Dist[stores.size()][houses.size()];
        for (int i = 0; i < stores.size(); i++) {
            int[] store = stores.get(i);
            for (int j = 0; j < houses.size(); j++) {
                int[] house = houses.get(j);
                int dist = Math.abs(store[0] - house[0]) + Math.abs(store[1] - house[1]);
                dists[i][j] = new Dist(j, dist);
            }
        }

        answer = Integer.MAX_VALUE;

        result = new int[houses.size()];
        Arrays.fill(result, Integer.MAX_VALUE);
        backtrack(0, 0);

        System.out.println(answer);

    }

    private static void backtrack(int index, int count) {
        if (count == M) {
            answer = Math.min(answer, getSum());
            return;
        }
        if (index == dists.length) {
            return;
        }
        int[] before = result.clone();
        for (int i = 0; i < dists[index].length; i++) {
            Dist now = dists[index][i];
            result[now.position] = Math.min(result[now.position], now.dist);
        }
        backtrack(index + 1, count + 1);
        result = before;
        backtrack(index + 1, count);
    }

    private static int getSum() {
        int sum = 0;
        for (int i = 0; i < result.length; i++) {
            sum += result[i];
        }
        return sum;
    }
}

class Dist {
    int position;
    int dist;

    Dist(int position, int dist) {
        this.position = position;
        this.dist = dist;
    }
}