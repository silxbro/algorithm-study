package src.problem.baekjoon.level06_심화_1;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class N25206_너의_평점은 {

    public static void main(String[] args) {
        Map<String, Double> scoreMap = new HashMap<>();
        scoreMap.put("A+", 4.5);
        scoreMap.put("A0", 4.0);
        scoreMap.put("B+", 3.5);
        scoreMap.put("B0", 3.0);
        scoreMap.put("C+", 2.5);
        scoreMap.put("C0", 2.0);
        scoreMap.put("D+", 1.5);
        scoreMap.put("D0", 1.0);
        scoreMap.put("F", 0.0);

        Scanner scanner = new Scanner(System.in);
        double totalRating = 0;
        int totalCredit = 0;
        for (int i = 0; i < 20; i++) {
            String subject = scanner.next();
            double credit = scanner.nextDouble();
            String grade = scanner.next();
            if (grade.equals("P")) {
                continue;
            }
            totalCredit += credit;
            totalRating += credit * scoreMap.get(grade);
        }

        System.out.println(totalRating / totalCredit);
    }
}