package src.book.알고리즘_코딩테스트.ch07;

import java.util.Scanner;

public class exam042_최소공배수 {
  public static void main(String[] args) throws Exception {
    Scanner sc = new Scanner(System.in);
    int testCount = sc.nextInt();
    for (int test = 0; test < testCount; test++) {
      int firstValue = sc.nextInt();
      int secondValue = sc.nextInt();
      int result = (firstValue * secondValue) / gcdFunc(firstValue, secondValue);
      System.out.println(result);
    }
  }
  public static int gcdFunc(int value1, int value2) {
    if (value2 == 0) {
      return value1;
    }
    return gcdFunc(value2, value1 % value2);  // 재귀 함수의 형태로 구현
  }
}
