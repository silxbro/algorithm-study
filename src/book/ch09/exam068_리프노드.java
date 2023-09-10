package src.book.ch09;

import java.util.ArrayList;
import java.util.Scanner;

public class exam068_리프노드 {
  static int leafNodeNumber;
  static int removeNodeNumber, rootNodeNumber;
  static int nodeNumber;
  static ArrayList<Integer>[] tree;
  static boolean[] visited;
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    nodeNumber = sc.nextInt();
    tree = new ArrayList[nodeNumber];
    visited = new boolean[nodeNumber];
    for (int i = 0; i < nodeNumber; i++) {
      tree[i] = new ArrayList<>();
    }
    for (int i = 0; i < nodeNumber; i++) {
      int parentNodeNumber = sc.nextInt();
      if (parentNodeNumber != -1) {
        tree[i].add(parentNodeNumber);
        tree[parentNodeNumber].add(i);
      } else {
        rootNodeNumber = i;
      }
    }
    removeNodeNumber = sc.nextInt();

    if (removeNodeNumber == rootNodeNumber) {
      System.out.println(0);
    } else {
      leafNodeNumber = 0;
      DFS(rootNodeNumber);
      System.out.println(leafNodeNumber);
    }
  }
  private static void DFS(int nowNode) {
    visited[nowNode] = true;
    int childNodeCount = 0;
    for (int nextNode : tree[nowNode]) {
      if (!visited[nextNode] && nextNode != removeNodeNumber) {  // 삭제 노드가 아닐 때도 탐색 중지
        childNodeCount++;
        DFS(nextNode);
      }
    }
    if (childNodeCount == 0)  // 자식 노드가 아닐 때 리프 노드로 간주하고 정답값 증가
      leafNodeNumber++;
  }
}
