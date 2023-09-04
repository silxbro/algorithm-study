package src.book.ch06;

import java.util.PriorityQueue;
import java.util.Scanner;

public class exam033_카드정렬하기 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int cardSetCount = sc.nextInt();
    int compareCount = 0;
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    for (int i = 0; i < cardSetCount; i++) {
      pq.add(sc.nextInt());
    }
    while (pq.size() > 1) {
      int firstSet = pq.remove();
      int secondSet = pq.remove();
      pq.add(firstSet + secondSet);
      compareCount += firstSet + secondSet;
    }
    System.out.println(compareCount);
  }
}
