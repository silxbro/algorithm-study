package src.problem.baekjoon.class02_silver;

import java.util.Scanner;

class N1515_수_이어_쓰기 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();

        long num = 0;
        int index = 0;
        while (index < str.length()) {
            String numStr = String.valueOf(++num);
            for (int i = 0; i < numStr.length(); i++) {
                if (index >= str.length()) {
                    break;
                }
                char target = str.charAt(index);
                if (numStr.charAt(i) == target) {
                    index++;
                }
            }
        }

        System.out.println(num);
    }
}