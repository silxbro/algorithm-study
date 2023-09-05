package src.book.ch07;

import java.util.Scanner;

public class exam041_GCDNK1 {
  public static void main(String[] args) throws Exception {
    Scanner sc = new Scanner(System.in);
    long num = sc.nextLong();
    long result = num;
    for (int n = 2; n <= Math.sqrt(num); n++) {    // 제곱근까지만 진행하기
      if (num % n == 0) {                // 1. n이 소인수인지 확인
        result = result - result / n;    // 2. 결괏값 업데이트
        while (num % n == 0) {           // 3. 소인수 제거
          num /= n;
        }
      }
    }
    if (num > 1) {   // 아직 소인수 구성이 남아 있을 때
      // *** 반복문에서 제곱근까지만 탐색했으므로 1개의 소인수가 누락되는 케이스
      result = result - result / num;
    }
    System.out.println(result);
  }
}
