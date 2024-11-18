package src.problem.baekjoon.class03_gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class N20055_컨베이어_벨트_위의_로봇 {

    static int N, K;
    static int[] dur;
    static boolean[] robot;
    static int zero;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        dur = new int[2 * N];
        robot = new boolean[2 * N];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < dur.length; i++) {
            dur[i] = Integer.parseInt(st.nextToken());
            if (dur[i] == 0) zero++;
        }

        int level = 0;
        while (true) {
            ++level;
            beltRotate();
            robotMove();
            addRobot();
            if (zero >= K) {
                break;
            }
        }
        System.out.println(level);
    }

    private static void addRobot() {
        if (dur[0] > 0) {
            robot[0] = true;
            dur[0]--;
            if (dur[0] == 0) {
                zero++;
            }
        }
    }

    private static void beltRotate() {
        boolean[] newRobot = new boolean[2 * N];
        newRobot[0] = robot[2 * N - 1];
        for (int i = 0; i < newRobot.length - 1; i++) {
            newRobot[i + 1] = robot[i];
        }
        robot = newRobot;
        if (robot[N - 1]) {
            robot[N - 1] = false;
            robot[N] = true;
            dur[N]--;
        }
    }


    private static void robotMove() {
        robot[2 * N - 1] = false;
        move(N - 1, N);
        for (int i = 2 * N - 2; i >= 0; i--) {
            move(i, i + 1);
        }
    }

    private static void move(int from, int to) {
        if (robot[from] && !robot[to] && dur[to] > 0) {
            robot[from] = false;
            robot[to] = true;
            dur[to]--;
            if (dur[to] == 0) {
                zero++;
            }
        }
    }

}
