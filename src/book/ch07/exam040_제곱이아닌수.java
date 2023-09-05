package src.book.ch07;

import java.util.Scanner;

public class exam040_제곱이아닌수 {
  public static void main(String[] args) throws Exception {
    Scanner sc = new Scanner(System.in);
    long minValue = sc.nextInt();
    long maxValue = sc.nextInt();
    // 최댓값과 최솟값의 차이만큼 배열 선언하기
    boolean[] checkValue = new boolean[(int) (maxValue - minValue + 1)];
    // 2의 제곱수인 4부터 Max보다 작거나 같은 값까지 반복하기
    for (long num = 2; num * num <= maxValue; num++) {
      long pow = num * num;                   // 제곱수
      long startIndex = minValue / pow;
      if (minValue % pow != 0) startIndex++;  // 나머지가 있으면 1을 더해야 Min보다 큰 제곱수에서 시작됨
      for (long mul = startIndex; mul * pow <= maxValue; mul++) {   // 제곱수를 true로 변경하기
        checkValue[(int) (mul * pow - minValue)] = true;
      }
    }
    int notCheckedCount = 0;
    for (int i = 0; i < checkValue.length; i++) {
      if (checkValue[i] == false)
        notCheckedCount++;
    }
    System.out.println(notCheckedCount);
  }
}
