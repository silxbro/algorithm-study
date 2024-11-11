package src.problem.baekjoon.class03_gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class N2179_비슷한_단어 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] arr = new String[N];
        int maxLen = 0;
        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine();
            maxLen = Math.max(maxLen, arr[i].length());
        }

        Map<String, List<Integer>> result = new HashMap<>();
        int[] answer = new int[2];
        Arrays.fill(answer, Integer.MAX_VALUE);
        for (int i = maxLen; i >= 1; i--) {
            for (int j = 0; j < N; j++) {
                if (arr[j].length() >= i) {
                    String substr = arr[j].substring(0, i);
                    List<Integer> list = result.getOrDefault(substr, new ArrayList<>());
                    if (list.size() < 2) {
                        list.add(j);
                    }

                    if (list.size() == 2) {
                        if (arr[list.get(0)].equals(arr[j])) {
                            list.remove(1);
                        } else {
                            if (answer[0] > list.get(0)) {
                                answer[0] = list.get(0);
                                answer[1] = list.get(1);
                            }
                        }
                    }
                    result.put(substr, list);
                }

            }
            if (answer[0] != Integer.MAX_VALUE) {
                break;
            }
        }

        System.out.println(arr[answer[0]]);
        System.out.println(arr[answer[1]]);
    }
}