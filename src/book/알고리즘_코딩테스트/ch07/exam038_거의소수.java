package src.book.알고리즘_코딩테스트.ch07;

import java.util.Scanner;

public class exam038_거의소수 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int answerCount = 0;
    int minNumber = sc.nextInt();
    int maxNumber = sc.nextInt();
    int[] primeNumCheck = new int[10000001];
    for (int i = 2; i <= 10000000; i++) {
      primeNumCheck[i] = i;
    }
    for (int i = 2; i * i <= 10000000; i++) {        // 제곱근까지만 수행하기
      if (primeNumCheck[i] == 0)
        continue;
      for (int j = i + i; j <= 10000000; j += i) {   // 배수 지우기
        primeNumCheck[j] = 0;
      }
    }
    for (int num = 2; num <= 10000000; num++) {
      if (primeNumCheck[num] != 0) {
        int temp = num;
        while ((double)num <= (double)maxNumber / (double)temp) {
          if ((double)num >= (double)minNumber / (double)temp) {
            answerCount++;
          }
          temp = temp * num;   // *** 식 위치 주의
        }
      }
    }
    System.out.println(answerCount);
  }
}
