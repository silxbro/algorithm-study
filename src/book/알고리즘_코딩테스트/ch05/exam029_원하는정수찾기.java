package src.book.알고리즘_코딩테스트.ch05;

import java.util.Arrays;
import java.util.Scanner;

public class exam029_원하는정수찾기 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int arrLen = sc.nextInt();
    int[] arr = new int[arrLen];
    for (int i = 0; i < arrLen; i++) {
      arr[i] = sc.nextInt();
    }
    Arrays.sort(arr);
    int findNumCount = sc.nextInt();
    // 이진 탐색
    for (int i = 0; i < findNumCount; i++) {
      int findNum = sc.nextInt();
      boolean find = false;
      int startIndex = 0;
      int endIndex = arrLen - 1;
      while (startIndex <= endIndex) {
        int middleIndex = (startIndex + endIndex) / 2;
        int middleValue = arr[middleIndex];
        if (middleValue > findNum) {
          endIndex = middleIndex - 1;
        } else if (middleValue < findNum) {
          startIndex = middleIndex + 1;
        } else {
          find = true;
          break;
        }
      }
      if (find)
        System.out.println("1");
      else
        System.out.println("0");
    }
  }
}
