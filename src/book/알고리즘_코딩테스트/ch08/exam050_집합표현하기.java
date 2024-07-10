package src.book.알고리즘_코딩테스트.ch08;

import java.util.Scanner;

public class exam050_집합표현하기 {
  static int[] parent;
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int nodeCount = sc.nextInt();
    int calCount = sc.nextInt();
    parent = new int[nodeCount + 1];
    for (int i = 1; i <= nodeCount; i++) {    // 대표 노드를 자기 자신으로 초기화하기
      parent[i] = i;
    }
    for (int i = 0; i < calCount; i++) {
      int calNum = sc.nextInt();
      int nodeA = sc.nextInt();
      int nodeB = sc.nextInt();
      if (calNum == 0) {         // 집합 합치기
        union(nodeA, nodeB);
      }
      else if (calNum == 1) {    // 같은 집합의 원소인지 확인하기
        if (checkSame(nodeA, nodeB)) {
          System.out.println("YES");
        } else {
          System.out.println("NO");
        }
      }
    }
  }
  private static void union(int node1, int node2) {           // union 연산 : 대표 노드끼리 연결하기
    node1 = find(node1);
    node2 = find(node2);
    if (node1 != node2) {
      parent[node2] = node1;
    }
  }
  private static int find(int node) {                         // find 연산
    if (node == parent[node]) {
      return node;
    }
    return parent[node] = find(parent[node]);  // *** 재귀 함수의 형태로 구현 -> 경로 압축 부분
  }
  private static boolean checkSame(int node1, int node2) {    // 두 원소가 같은 집합인지 확인하기
    node1 = find(node1);
    node2 = find(node2);
    if (node1 == node2) {
      return true;
    }
    return false;
  }
}
