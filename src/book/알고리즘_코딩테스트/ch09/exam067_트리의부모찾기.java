package src.book.알고리즘_코딩테스트.ch09;

import java.util.ArrayList;
import java.util.Scanner;

public class exam067_트리의부모찾기 {
  static int nodeNumber;
  static ArrayList<Integer>[] tree;
  static boolean[] visited;
  static int[] parentNode;
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    nodeNumber = sc.nextInt();
    tree = new ArrayList[nodeNumber + 1];
    visited = new boolean[nodeNumber + 1];
    parentNode = new int[nodeNumber + 1];
    for (int i = 1; i <= nodeNumber; i++) {
      tree[i] = new ArrayList<>();
    }
    for (int i = 0; i < nodeNumber - 1; i++) {
      int nodeA = sc.nextInt();
      int nodeB = sc.nextInt();
      tree[nodeA].add(nodeB);
      tree[nodeB].add(nodeA);
    }
    DFS(1);   // 부모 노드부터 DFS 시작
    for (int i = 2; i <= nodeNumber; i++) {
      System.out.println(parentNode[i]);
    }
  }
  private static void DFS(int nowNode) {
    visited[nowNode] = true;
    for (int nextNode : tree[nowNode]) {
      if (!visited[nextNode]) {
        parentNode[nextNode] = nowNode;  // DFS를 탐색하면서 부모 노드를 정답 배열에 저장
        DFS(nextNode);
      }
    }
  }
}
