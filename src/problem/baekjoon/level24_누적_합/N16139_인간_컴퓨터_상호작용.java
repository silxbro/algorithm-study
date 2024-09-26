package src.problem.baekjoon.level24_누적_합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class N16139_인간_컴퓨터_상호작용 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String str = br.readLine();
        int[][] sumCount = new int[26][str.length() + 1];
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            for (char j = 'a'; j <= 'z'; j++) {
                sumCount[j - 'a'][i + 1] = (j == c) ? sumCount[j - 'a'][i] + 1 : sumCount[j - 'a'][i];
            }
        }

        int qCount = Integer.parseInt(br.readLine());
        StringBuilder stb = new StringBuilder();
        for (int q = 0; q < qCount; q++) {
            st = new StringTokenizer(br.readLine());
            char c = st.nextToken().charAt(0);
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            stb.append(sumCount[c - 'a'][e + 1] - sumCount[c - 'a'][s]).append("\n");
        }
        System.out.println(stb);
    }
}