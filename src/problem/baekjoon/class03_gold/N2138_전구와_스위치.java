package src.problem.baekjoon.class03_gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class N2138_전구와_스위치 {

    static int N;
    static char[] from, to;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        from = br.readLine().toCharArray();
        to = br.readLine().toCharArray();

        int result1 = getCount(true); // 맨 처음 스위치를 누른 경우
        int result2 = getCount(false); // 맨 처음 스위치를 누르지 않은 경우

        if (result1 == -1 || result2 == -1) {
            System.out.println(Math.max(result1, result2));
        } else {
            System.out.println(Math.min(result1, result2));
        }
    }

    private static int getCount(boolean firstPress) {
        char[] temp = from.clone();
        int count = 0;

        // 첫 번째 스위치 누름
        if (firstPress) {
            press(temp, 0);
            count++;
        }

        // 두 번째 스위치부터 차례로 조작
        for (int i = 1; i < N; i++) {
            if (temp[i - 1] != to[i - 1]) { // 이전 스위치를 비교하기 **
                press(temp, i);
                count++;
            }
        }

        // 마지막 상태 검사
        if (temp[N - 1] != to[N - 1]) {
            return -1;
        }

        return count;
    }

    private static void press(char[] now, int index) {
        now[index] = now[index] == '1' ? '0' : '1';
        if (index - 1 >= 0) {
            now[index - 1] = now[index - 1] == '1' ? '0' : '1';
        }
        if (index + 1 < now.length) {
            now[index + 1] = now[index + 1] == '1' ? '0' : '1';
        }
    }
}