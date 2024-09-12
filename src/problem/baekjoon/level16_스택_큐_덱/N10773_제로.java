package src.problem.baekjoon.level16_스택_큐_덱;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

class N10773_제로 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());

        Stack<Long> numbers = new Stack<>();
        long sum = 0;

        for (int i = 0; i < K; i++) {
            long number = Long.parseLong(br.readLine());
            if (number == 0) {
                long removed = numbers.pop();
                sum -= removed;
                continue;
            }
            numbers.push(number);
            sum += number;
        }
        System.out.println(sum);
    }
}