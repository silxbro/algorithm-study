package src.book.알고리즘_코딩테스트.ch04;

import java.util.Scanner;

public class exam018_ATM {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] ownTime = new int[n];
    int[] wholeTime = new int[n];
    for (int i = 0; i < n; i++) {
      ownTime[i] = sc.nextInt();
    }
    for (int i = 1; i < n; i++) {   // 삽입 정렬
      int insert_point = i;
      int insert_value = ownTime[i];
      for (int j = i - 1; j >= 0; j--) {
        if (insert_value >= ownTime[j]) {
          insert_point = j + 1;
          break;
        }
        if (j == 0) {
          insert_point = 0;
        }
      }
      for (int j = i; j > insert_point; j--) {
        ownTime[j] = ownTime[j - 1];
      }
      ownTime[insert_point] = insert_value;
    }
    wholeTime[0] = ownTime[0];     // *** 실수하기 쉬운 부분 주의
    for (int i = 1; i < n; i++) {
      wholeTime[i] = wholeTime[i-1] + ownTime[i];
    }
    int allTime = 0;               // 합 배열 총합 구하기
    for (int i = 0; i < n; i++) {
      allTime += wholeTime[i];
    }
    System.out.println(allTime);
  }
}
