package src.book.ch08;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class exam053_줄세우기 {
  static int[] indegree;
  static ArrayList<Integer>[] heightCompare;
  static int studentNumber;
  static int compareNumber;
  public static void main(String[] args) throws Exception {
    Scanner sc = new Scanner(System.in);
    studentNumber = sc.nextInt();
    compareNumber = sc.nextInt();
    heightCompare = new ArrayList[studentNumber + 1];
    indegree = new int[studentNumber + 1];
    for (int i = 1; i <= studentNumber; i++) {
      heightCompare[i] = new ArrayList<>();
    }
    for (int i = 0; i < compareNumber; i++) {
      int frontOrder = sc.nextInt();
      int backOrder = sc.nextInt();
      heightCompare[frontOrder].add(backOrder);
      indegree[backOrder]++;  // 진입 차수 배열 데이터 저장하기
    }

    // 위상 정렬 수행하기
    Queue<Integer> queue = new LinkedList<>();
    for (int i = 1; i <= studentNumber; i++) {
      if (indegree[i] == 0) {
        queue.add(i);
      }
    }
    while (!queue.isEmpty()) {
      int nowStudent = queue.poll();
      System.out.print(nowStudent + " ");
      for (int nextStudent : heightCompare[nowStudent]) {
        indegree[nextStudent]--;
        if (indegree[nextStudent] == 0) {
          queue.add(nextStudent);
        }
      }
    }
  }
}
