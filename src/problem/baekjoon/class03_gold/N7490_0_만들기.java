package src.problem.baekjoon.class03_gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

class N7490_0_만들기 {

    static StringBuilder stb;
    static int[] operation;
    static int num;
    static PriorityQueue<String> answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        stb = new StringBuilder();

        for (int t = 0; t < T; t++) {
            answer = new PriorityQueue<>();
            num = Integer.parseInt(br.readLine());
            operation = new int[num + 1];
            operation[1] = 1;
            backtrack(2, 1);
            while (!answer.isEmpty()) {
                stb.append(answer.poll());
                stb.append("\n");
            }
            stb.append("\n");
        }

        System.out.println(stb);
    }

    private static void backtrack(int now, int sum) {
        if (now > num) {
            if (sum == 0) {
                answer.add(byString());
            }
            return;
        }
        //더하기
        operation[now] = 1;
        backtrack(now + 1, sum + now);
        //빼기
        operation[now] = 2;
        backtrack(now + 1, sum - now);
        //붙이기
        operation[now] = 3;
        backtrack(now + 1, getNewSum(now));
        operation[now] = 0;
    }

    private static int getNewSum(int now) {
        int sum = 0;
        for (int i = now; i >= 1; i--) {
            if (operation[i] == 3) {
                String num = "";
                while(operation[i] == 3) {
                    num = i + num;
                    i--;
                }
                num = i + num;
                int temp = Integer.parseInt(num);
                if (operation[i] == 1) {
                    sum += temp;
                } else {
                    sum -= temp;
                }
            } else {
                if (operation[i] == 1) {
                    sum += i;
                } else {
                    sum -= i;
                }
            }
        }
        return sum;
    }

    private static String byString() {
        StringBuilder stb = new StringBuilder();
        stb.append(1);
        for (int i = 2; i <= num; i++) {
            stb.append(operation[i] == 1 ? "+" : operation[i] == 2 ? "-" : " ").append(i);
        }
        return stb.toString();
    }
}