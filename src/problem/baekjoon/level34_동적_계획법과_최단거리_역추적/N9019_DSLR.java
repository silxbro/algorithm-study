package src.problem.baekjoon.level34_동적_계획법과_최단거리_역추적;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

class N9019_DSLR {

    static int[] dp;
    static Stack<Character> stack;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        StringBuilder stb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            dp = new int[10001];
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            stb.append(getCommand(A, B)).append("\n");
        }
        System.out.println(stb);

    }

    private static String getCommand(int start, int end) {
        bfs(start, end);
        int number = end;
        StringBuilder command = new StringBuilder();
        stack = new Stack<>();
        while (number != start) {
            number = getBefore(number);
        }
        while (!stack.isEmpty()) {
            command.append(stack.pop());
        }
        return command.toString();
    }


    private static void bfs(int start, int end) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        dp[start] = 1;
        while (!queue.isEmpty()) {
            int now = queue.poll();
            if (now == end) {
                break;
            }
            for (int next : getNext(now)) {
                if (dp[next] == 0) {
                    dp[next] = dp[now] + 1;
                    queue.add(next);
                }
            }
        }
    }

    private static int getBefore(int number) {
        if (number % 2 == 0) {
            if (dp[number] == dp[number / 2] + 1) {
                stack.push('D');
                return number / 2;
            }
            if (dp[number] == dp[(number + 10000) / 2] + 1) {
                stack.push('D');
                return (number + 10000) / 2;
            }
        }
        int before = number == 9999 ? 0 : number + 1;
        if (dp[number] == dp[before] + 1) {
            stack.push('S');
            return before;
        }
        before = (number % 10) * 1000 + number / 10;
        if (dp[number] == dp[before] + 1) {
            stack.push('L');
            return before;
        }
        stack.push('R');
        return (number % 1000) * 10 + number / 1000;
    }

    private static int[] getNext(int number) {
        return new int[]{number * 2 % 10000
            , number == 0 ? 9999 : number - 1
            , (number % 1000) * 10 + number / 1000
            , (number % 10) * 1000 + number / 10
        };
    }
}