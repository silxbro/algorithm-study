package src.problem.baekjoon.level07_2차원_배열;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class N10798_세로읽기 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<StringBuilder> strList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            String str = scanner.next();
            for (int j = 0; j < str.length(); j++) {
                if (j >= strList.size()) {
                    strList.add(new StringBuilder().append(str.charAt(j)));
                    continue;
                }
                strList.get(j).append(str.charAt(j));
            }
        }
        String result = String.join("", strList);
        System.out.println(result);
    }
}