package src.problem.baekjoon.class02_silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class N17615_볼_모으기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String balls = br.readLine();

        int count1 = 0;
        int count2 = 0;
        int index = 0;
        char front = balls.charAt(index);
        while (index >= 0 && index < N && balls.charAt(index) == front) {
            index++;
        }
        for (int i = index; i < balls.length(); i++) {
            if (balls.charAt(i) == front) {
                count1++;
            } else {
                count2++;
            }
        }
        int answer = Math.min(count1, count2);

        count1 = 0;
        count2 = 0;
        index = balls.length() - 1;
        front = balls.charAt(index);
        while (index >= 0 && index < N && balls.charAt(index) == front) {
            index--;
        }
        for (int i = index; i >= 0; i--) {
            if (balls.charAt(i) == front) {
                count1++;
            } else {
                count2++;
            }
        }
        answer = Math.min(answer, Math.min(count1, count2));

        System.out.println(answer);
    }
}