package src.book.ch07;

import java.util.Scanner;

public class exam037_소수구하기 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int firstNumber = sc.nextInt();
    int lastNumber = sc.nextInt();
    int[] primeCheck = new int[lastNumber + 1];
    for (int num = 1; num <= lastNumber; num++) {
      primeCheck[num] = num;
    }
    for (int num = 2; num <= Math.sqrt(lastNumber); num++) {      // 제곱근까지만 수행하기
      if (primeCheck[num] == 0)
        continue;
      for (int mul = num + num; mul <= lastNumber; mul += num) {  // 배수 지우기
        primeCheck[mul] = 0;
      }
    }
    for (int num = firstNumber; num <= lastNumber; num++) {
      if (primeCheck[num] != 0) {
        System.out.println(num);
      }
    }
  }
}
