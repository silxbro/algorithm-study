package src.problem.baekjoon.class01_bronze;

import static java.time.ZoneOffset.UTC;
import java.time.LocalDateTime;

public class N10699_오늘_날짜 {

    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now(UTC);
        int year = now.getYear();
        int month = now.getMonthValue();
        int day = now.getDayOfMonth();
        System.out.printf("%04d-%02d-%02d", year, month, day);
    }
}