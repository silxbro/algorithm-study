package src.book.알고리즘_코딩테스트.ch06;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class exam034_수묶기 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int numberCount = sc.nextInt();

    PriorityQueue<Integer> plusPq = new PriorityQueue<>(Collections.reverseOrder());
    PriorityQueue<Integer> minusPq = new PriorityQueue<>();
    int one = 0;
    int zero = 0;

    // 4개의 그룹으로 분리해 저장하기
    for (int i = 0; i < numberCount; i++) {
      int num = sc.nextInt();
      if (num > 1) {
        plusPq.add(num);
      } else if (num == 1) {
        one++;
      } else if (num == 0) {
        zero++;
      } else {
        minusPq.add(num);
      }
    }

    int maxSum = 0;
    // 1보다 큰 수 처리
    while(plusPq.size() > 1) {
      int firstValue = plusPq.remove();
      int secondValue = plusPq.remove();
      maxSum += firstValue * secondValue;
    }
    if (!plusPq.isEmpty()) {
      maxSum += plusPq.remove();
    }
    // 음수 처리
    while (minusPq.size() > 1) {
      int firstValue = minusPq.remove();
      int secondValue = minusPq.remove();
      maxSum += firstValue * secondValue;
    }
    if (!minusPq.isEmpty()) {
      if (zero == 0) {
        maxSum += minusPq.remove();
      }
    }
    // 1 처리
    maxSum += one;

    System.out.println(maxSum);
  }
}
