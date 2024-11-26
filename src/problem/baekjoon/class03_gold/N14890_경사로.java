package src.problem.baekjoon.class03_gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class N14890_경사로 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int[][] map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int count = 0;

        for (int i = 0; i < N; i++) {
            //가로
            if (canAcross(map[i], L)) {
                count++;
            }
            //세로
            int[] road = new int[N];
            for (int j = 0; j < N; j++) {
                road[j] = map[j][i];
            }
            if (canAcross(road, L)) {
                count++;
            }
        }

        System.out.println(count);

    }

    private static boolean canAcross(int[] road, int len) {
        boolean result = true;
        int[] seq = new int[road.length];
        seq[0]++;
        int index = 1;
        while (index < road.length) {
            if (road[index] == road[index - 1]) {
                seq[index] = seq[index - 1] + 1;
                index++;
            } else if ((road[index] == road[index - 1] + 1) && seq[index - 1] >= len) {
                seq[index] = 1;
                index++;
            } else if (road[index] == road[index - 1] - 1) {
                int sameCount = 1;
                int num = road[index];
                for (int i = 1; i < len; i++) {
                    index++;
                    if (index < road.length && road[index] == num) {
                        sameCount++;
                    } else {
                        break;
                    }
                }
                if (sameCount < len) {
                    result = false;
                    break;
                }
                index++;
            } else {
                result = false;
                break;
            }
        }
        return result;
    }
}
