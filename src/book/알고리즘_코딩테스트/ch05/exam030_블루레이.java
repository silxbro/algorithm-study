package src.book.알고리즘_코딩테스트.ch05;

import java.util.Scanner;

public class exam030_블루레이 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int lessonCount = sc.nextInt();
    int bluerayCount = sc.nextInt();
    int[] lessonLengthArray = new int[lessonCount];
    int start = 0;
    int end = 0;
    for (int i = 0; i < lessonCount; i++) {
      lessonLengthArray[i] = sc.nextInt();
      if (lessonLengthArray[i] > start) start = lessonLengthArray[i];  // 레슨 최댓값을 시작 인덱스로 저장
      end += lessonLengthArray[i];                                     // 레슨 총합을 종료 인덱스로 저장
    }
    while (start <= end) {
      int middle = (start + end) / 2;
      int lessonLengthSum = 0;
      int tempCount = 0;
      for (int i = 0; i < lessonCount; i++) {   // middle값으로 모든 레슨을 저장할 수 있는지 확인
        if (lessonLengthSum + lessonLengthArray[i] > middle) {
          tempCount++;
          lessonLengthSum = 0;
        }
        lessonLengthSum += lessonLengthArray[i];
      }
      if (lessonLengthSum > 0) tempCount++;    // 탐색 후 sum이 0이 아니면 블루레이가 1개 더 필요하므로 더함

      if (tempCount > bluerayCount) {
        start = middle + 1;
      } else {
        end = middle - 1;
      }
    }
    System.out.println(start);
  }
}
