package src.problem.baekjoon.level20_심화_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

class N2108_통계학 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Map<Integer, Integer> counts = new TreeMap<>();
        List<Integer> numbers = new ArrayList<>();
        List<Integer> maxCountValue = new ArrayList<>();
        int maxCount = 0;
        long sum = 0;

        for (int i = 0; i < N; i++) {
            int number = Integer.parseInt(br.readLine());
            sum += number;
            counts.put(number, counts.getOrDefault(number,0) + 1);
            int count = counts.get(number);
            if (count == maxCount) {
                maxCountValue.add(number);
            }
            if (count > maxCount) {
                maxCount = count;
                maxCountValue.clear();
                maxCountValue.add(number);
            }
            numbers.add(number);
        }

        Collections.sort(numbers);

        System.out.println(Math.round(sum * 10.0 / N / 10));
        System.out.println(numbers.get(N / 2));

        if (maxCountValue.size() > 1) {
            Collections.sort(maxCountValue);
            System.out.println(maxCountValue.get(1));
        } else {
            System.out.println(maxCountValue.get(0));
        }

        System.out.println(numbers.get(N - 1) - numbers.get(0));
    }
}