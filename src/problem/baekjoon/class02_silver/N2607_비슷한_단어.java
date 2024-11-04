package src.problem.baekjoon.class02_silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class N2607_비슷한_단어 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        String first = br.readLine();
        int count = 0;
        for (int i = 0; i < N - 1; i++) {
            String other = br.readLine();
            if (similar(first, other)) {
                count++;
            }
        }

        System.out.println(count);
    }

    private static boolean similar(String str1, String str2) {
        String first = str1;
        String second = str2;
        for (int i = 0; i < str2.length(); i++) {
            String target = str2.substring(i, i + 1);
            if (first.contains(target)) {
                first = first.replaceFirst(target, "");
                second = second.replaceFirst(target, "");
            }
        }
        return first.length() <= 1 && second.length() <= 1;
    }
}