package src.problem.baekjoon.class03_gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N17406_배열_돌리기 {
    static int N, M, K;
    static Operation[] operations;
    static boolean[] visited;
    static int[][] map;
    static int[] dr = {1, 0, -1, 0};
    static int[] dc = {0, 1, 0, -1};
    static int min;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        operations = new Operation[K];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            operations[i] = new Operation(r - 1, c - 1, s);
        }

        visited = new boolean[K];
        min = Integer.MAX_VALUE;
        backtrack(0);

        System.out.println(min);
    }

    private static void backtrack(int count) {
        if (count == K) {
            min = Math.min(min, getValue());
            return;
        }
        int[][] copied = copy(map);
        for (int i = 0; i < K; i++) {
            if (!visited[i]) {
                visited[i] = true;
                operate(i);
                backtrack(count + 1);
                visited[i] = false;
                map = copy(copied);
            }
        }
    }

    private static void operate(int index) {
        Operation target = operations[index];
        for (int s = 1; s <= target.s; s++) {
            int temp = map[target.r - s][target.c - s];
            int r = target.r - s;
            int c = target.c - s;
            int d = 0;
            while (true) {
                int nextR = r + dr[d];
                int nextC = c + dc[d];
                if (nextR == target.r - s && nextC == target.c - s) {
                    break;
                }
                if (nextR < target.r - s || nextR > target.r + s || nextC < target.c - s || nextC > target.c + s) {
                    d++;
                } else {
                    map[r][c] = map[nextR][nextC];
                    r = nextR;
                    c = nextC;
                }
            }
            map[target.r - s][target.c - s + 1] = temp;
        }
    }

    private static int getValue() {
        int minValue = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            int sum = 0;
            for (int j = 0; j < M; j++) {
                sum += map[i][j];
            }
            minValue = Math.min(minValue, sum);
        }
        return minValue;
    }

    private static int[][] copy(int[][] original) {
        int[][] copied = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                copied[i][j] = original[i][j];
            }
        }
        return copied;
    }
}

class Operation {
    int r;
    int c;
    int s;

    public Operation(int r, int c, int s) {
        this.r = r;
        this.c = c;
        this.s = s;
    }
}