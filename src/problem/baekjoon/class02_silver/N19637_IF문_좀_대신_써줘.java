package src.problem.baekjoon.class02_silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

class N19637_IF문_좀_대신_써줘 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Map<Integer, String> map = new TreeMap<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int power = Integer.parseInt(st.nextToken());
            if (!map.containsKey(power)) {
                map.put(power, name);
            }
        }

        int[] array = map.keySet().stream().mapToInt(Integer::intValue).toArray();
        StringBuilder stb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            int target = Integer.parseInt(br.readLine());
            int result = 0;
            int s = 0;
            int e = array.length - 1;
            while (s <= e) {
                int m = (s + e) / 2;
                if (array[m] >= target) {
                    result = array[m];
                    e = m - 1;
                } else {
                    s = m + 1;
                }
            }
            stb.append(map.get(result)).append("\n");
        }

        System.out.println(stb);
    }
}