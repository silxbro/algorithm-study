package src.book.알고리즘_코딩테스트.ch09;

import java.util.Scanner;

public class exam070_트리순회 {
  static int[][] tree;
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int nodeNumber = sc.nextInt();
    sc.nextLine();
    tree = new int[26][2];    // 0 → 왼쪽 자식 노드(1) → 오른쪽 자식 노드(2)
    for (int i = 0; i < nodeNumber; i++) {
      String[] temp = sc.nextLine().split(" ");
      int node = temp[0].charAt(0) - 'A';  // index로 변환하기 위해 A 문자 빼기
      char left = temp[1].charAt(0);
      char right = temp[2].charAt(0);
      // 자식 노드가 없을 때 -1을 저장하기
      if (left == '.') {
        tree[node][0] = -1;
      } else {
        tree[node][0] = left - 'A';
      }
      if (right == '.') {
        tree[node][1] = -1;
      } else {
        tree[node][1] = right - 'A';
      }
    }
    preOrder(0);
    System.out.println();
    inOrder(0);
    System.out.println();
    postOrder(0);
  }
  private static void preOrder(int nodeNum) {
    if (nodeNum == -1) return;
    System.out.print((char)(nodeNum + 'A'));  // 1. 현재 노드
    preOrder(tree[nodeNum][0]);               // 2. 왼쪽 탐색하기
    preOrder(tree[nodeNum][1]);               // 3. 오른쪽 탐색하기
  }
  private static void inOrder(int nodeNum) {
    if (nodeNum == -1) return;
    inOrder(tree[nodeNum][0]);                // 1. 왼쪽 탐색하기
    System.out.print((char)(nodeNum + 'A'));  // 2. 현재 노드
    inOrder(tree[nodeNum][1]);                // 3. 오른쪽 탐색하기
  }
  private static void postOrder(int nodeNum) {
    if (nodeNum == -1) return;
    postOrder(tree[nodeNum][0]);              // 1. 왼쪽 탐색하기
    postOrder(tree[nodeNum][1]);              // 2. 오른쪽 탐색하기
    System.out.print((char)(nodeNum + 'A'));  // 3. 현재 노드
  }
}
