package src.problem.baekjoon.class02_silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class N20125_쿠키의_신체_측정 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] heart = new int[2];
        boolean findHeart = false;
        int leftEight = 0;
        int rightEight = 0;
        int waist = 0;
        int leftLeg = 0;
        int rightLeg = 0;

        for (int i = 1; i <= N; i++) {
            String line = br.readLine();
            for (int j = 0; j < line.length(); j++) {
                if (!findHeart && line.charAt(j) == '*') {
                    findHeart = true;
                    heart[0] = i + 1;
                    heart[1] = j + 1;
                }
                if (i == heart[0] && j + 1 < heart[1] && line.charAt(j) == '*') {
                    leftEight++;
                }
                if (i == heart[0] && j + 1 > heart[1] && line.charAt(j) == '*') {
                    rightEight++;
                }
                if (i > heart[0] && j + 1 == heart[1] && line.charAt(j) == '*') {
                    waist++;
                }
                if (i > heart[0] && j + 1 == heart[1] - 1 && line.charAt(j) == '*') {
                    leftLeg++;
                }
                if (i > heart[0] && j + 1 == heart[1] + 1 && line.charAt(j) == '*') {
                    rightLeg++;
                }
            }
        }

        StringBuilder stb = new StringBuilder();
        stb.append(heart[0]).append(" ").append(heart[1]).append("\n");
        stb.append(leftEight).append(" ").append(rightEight).append(" ")
            .append(waist).append(" ")
            .append(leftLeg).append(" ").append(rightLeg);

        System.out.println(stb);
    }
}