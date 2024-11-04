package src.problem.baekjoon.class02_silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class N1406_에디터 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stb = new StringBuilder(br.readLine());
        int index = stb.length();

        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            String command = br.readLine();
            if (command.startsWith("L")) {
                if (index > 0) {
                    index--;
                }
            } else if (command.startsWith("D")) {
                if (index < stb.length()) {
                    index++;
                }
            } else if (command.startsWith("B")) {
                if (index > 0) {
                    stb.deleteCharAt(index - 1);
                    index--;
                }
            } else if (command.startsWith("P")) {
                String s = command.split(" ")[1];
                stb.insert(index, s);
                index++;
            }
        }
        System.out.println(stb);
    }
}