package src.problem.baekjoon.level13_정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

class N18870_좌표_압축 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] numbers = new int[N];
        Map<Integer, Integer> countMap = new TreeMap<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
            countMap.put(numbers[i], 0);
        }

        int count = 0;
        for (Integer number : countMap.keySet()) {
            countMap.put(number, count++);
        }

        StringBuilder stb = new StringBuilder();
        for (int i = 0; i < numbers.length; i++) {
            stb.append(countMap.get(numbers[i])).append(" ");
        }
        System.out.println(stb);
    }
}