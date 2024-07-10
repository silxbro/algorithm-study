package src.book.알고리즘_코딩테스트.ch07;

import java.util.Scanner;

public class exam039_소수팰린드롬 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int num = sc.nextInt();
    int[] primeNumCheck = new int[10000001];             // N의 범위까지 소수 구하기
    for (int i = 2; i < primeNumCheck.length; i++) {
      primeNumCheck[i] = i;
    }
    for (int i = 2; i < Math.sqrt(primeNumCheck.length); i++) {  // 제곱근까지만 수행하기
      if (primeNumCheck[i] == 0) continue;
      for (int j  = i + i; j < primeNumCheck.length; j += i) {   // 배수 지우기
        primeNumCheck[j] = 0;
      }
    }
    while (true) {   // num부터 1씩 증가시키면서 소수와 팰린드롬 수가 맞는지 확인하기
      if (primeNumCheck[num] != 0 && isPalindrome(num)) {
        System.out.println(num);
        break;
      }
      num++;
    }
  }
  public static boolean isPalindrome(int number) {    // 팰린드롬 수 판별 함수
    boolean result = true;
    char[] tempArray = String.valueOf(number).toCharArray();
    int start = 0;
    int end = tempArray.length - 1;
    while (start < end) {
      if (tempArray[start] != tempArray[end]) {
        result = false;
        break;
      }
      start++;
      end--;
    }
    return result;
  }
}
