package src.problem.baekjoon.level14_집합과_맵;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

class N1620_나는야_포켓몬_마스터_이다솜 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<Integer, String> nameMap = new HashMap<>();
        Map<String, Integer> orderMap = new HashMap<>();

        for (int i = 1; i <= N; i++) {
            String name = br.readLine();
            nameMap.put(i, name);
            orderMap.put(name, i);
        }

        StringBuilder stb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            String key = br.readLine();
            String value = null;
            try {
                value = nameMap.get(Integer.parseInt(key));
            } catch (NumberFormatException e) {
                value = String.valueOf(orderMap.get(key));
            }
            stb.append(value).append("\n");
        }

        System.out.println(stb);
    }
}