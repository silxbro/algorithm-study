package src.problem.baekjoon.level21_재귀;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class N4779_칸토어_집합 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        StringBuilder stb = new StringBuilder();

        while ((line = br.readLine()) != null) {
            int N = Integer.parseInt(line);
            stb.append(cantorString(N)).append("\n");
        }

        System.out.println(stb);

    }

    private static String cantorString(int pow) {
        if (pow == 0) {
            return "-";
        }
        String part = cantorString(pow - 1);
        return part + " ".repeat((int) Math.pow(3, pow - 1)) + part;
    }
}