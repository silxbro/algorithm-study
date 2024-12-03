package src.problem.baekjoon.class03_gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class N17825_주사위_윷놀이 {

    static int[] redPath;
    static int[] bluePath;
    static int[] scores;
    static int[] positions;
    static int[] move;
    static int maxScore;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        move = new int[10];
        for (int i = 0; i < 10; i++) {
            move[i] = Integer.parseInt(st.nextToken());
        }

        pathInit();
        scoresInit();

        positions = new int[4];

        backtrack(0, 0);

        System.out.println(maxScore);
    }

    private static void backtrack(int index, int scoreSum) {
        if (index == 10) {
            maxScore = Math.max(maxScore, scoreSum);
            return;
        }
        int dist = move[index];
        //4개의 말 중, 도착지점이 있지 않고 다른 말이 있는 위치에 도달하지 않을 경우 이동 가능
        for (int i = 0; i < 4; i++) {
            int nextPosition = getNextPosition(i, dist);
            if (nextPosition != -1) {
                int original = positions[i];
                positions[i] = nextPosition;
                backtrack(index + 1, scoreSum + scores[positions[i]]);
                positions[i] = original;
            }
        }
    }

    private static int getNextPosition(int piece, int dist) {
        if (positions[piece] == 32) {
            return -1;
        }
        int p = positions[piece];
        for (int i = 0; i < dist; i++) {
            if (i == 0 && bluePath[p] != 0) {
                p = bluePath[p];
                continue;
            }
            p = redPath[p];
            if (p == 32) {
                break;
            }
        }
        for (int i = 0; i < 4; i++) {
            if (i != piece && p != 32 && positions[i] == p) {
                return -1;
            }
        }
        return p;
    }

    private static void scoresInit() {
        scores = new int[33];
        for (int i = 1; i <= 20; i++) {
            scores[i] = i * 2;
        }
        scores[21] = 13;
        scores[22] = 16;
        scores[23] = 19;
        scores[24] = 22;
        scores[25] = 24;
        scores[26] = 28;
        scores[27] = 27;
        scores[28] = 26;
        scores[29] = 25;
        scores[30] = 30;
        scores[31] = 35;
    }

    private static void pathInit() {
        redPath = new int[33];
        bluePath = new int[33];
        bluePath[5] = 21;
        bluePath[10] = 24;
        bluePath[15] = 26;
        for (int i = 1; i < redPath.length; i++) {
            redPath[i - 1] = i;
        }
        redPath[23] = 29;
        redPath[25] = 29;
        redPath[31] = 20;
        redPath[20] = 32;
    }
}