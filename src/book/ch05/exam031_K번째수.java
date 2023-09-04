package src.book.ch05;

import java.util.Scanner;

public class exam031_K번째수 {
  public static void main(String[] args) throws Exception {
    Scanner sc = new Scanner(System.in);
    int squareSize = sc.nextInt();
    int findOrder = sc.nextInt();
    int start = 1;
    int end = findOrder;
    int findNumber = 0;
    // 이진 탐색 수행하기
    while (start <= end) {
      int middle = (start + end) / 2;
      int count = 0;
      // 중앙값보다 작은 수는 몇 개인지 계산하기
      for (int i = 1; i <= squareSize; i++) {
        count += Math.min(middle / i, squareSize);  // *** 작은 수를 카운트하는 핵심 로직
      }
      if (count < findOrder) {
        start = middle + 1;
      } else {
        end = middle - 1;
        findNumber = middle;    // 현재 단계의 중앙값을 정답 변수에 저장하기
      }
    }
    System.out.println(findNumber);
  }
}
