package src.book.ch06;

import java.util.Scanner;

public class exam032_동전개수최솟값 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int coinKindCount = sc.nextInt();
    int allAmount = sc.nextInt();
    int[] coinArr = new int[coinKindCount];
    for (int i = 0; i < coinKindCount; i++) {
      coinArr[i] = sc.nextInt();
    }
    int minCoinCount = 0;
    for (int i = coinKindCount - 1; i >= 0; i--) {
      if (coinArr[i] <= allAmount) {        // 현재 동전의 가치가 전체 금액보다 작거나 같으면 구성에 추가
        minCoinCount += allAmount / coinArr[i];
        allAmount = allAmount % coinArr[i]; // 전체 금액을 현재 동전을 사용하고 남은 금액으로 갱신
      }
    }
    System.out.println(minCoinCount);
  }
}
