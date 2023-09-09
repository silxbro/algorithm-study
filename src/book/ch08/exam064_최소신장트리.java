package src.book.ch08;

import java.util.PriorityQueue;
import java.util.Scanner;

public class exam064_최소신장트리 {
  static int nodeNumber, edgeNumber;
  static int[] parent;
  static PriorityQueue<pNode> queue;
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    nodeNumber = sc.nextInt();  // 노드 수
    edgeNumber = sc.nextInt();  // 에지 수
    queue = new PriorityQueue<>(); // 자동 정렬을 위해 우선순위 큐 자료구조 선택하기
    parent = new int[nodeNumber + 1];
    for (int i = 1; i <= nodeNumber; i++) {
      parent[i] = i;
    }
    for (int i = 0; i < edgeNumber; i++) {
      int start = sc.nextInt();
      int end = sc.nextInt();
      int value = sc.nextInt();
      queue.add(new pNode(start, end, value));
    }
    int useEdge = 0;
    int minSpanningLength = 0;
    while (useEdge < nodeNumber - 1) {
      pNode now = queue.poll();
      if (find(now.start) != find(now.end)) {   // 같은 부모가 아니라면 연결해도 사이클이 생기지 않음
        union(now.start, now.end);
        minSpanningLength += now.value;
        useEdge++;
      }
    }
    System.out.println(minSpanningLength);
  }
  private static void union(int nodeA,int nodeB) {  // union 연산 : 대표 노드끼리 연결하기
    nodeA = find(nodeA);
    nodeB = find(nodeB);
    if (nodeA != nodeB) {
      parent[nodeB] = nodeA;
    }
  }
  private static int find(int node) {               // find 연산
    if (node == parent[node]) {
      return node;
    }
    return parent[node] = find(parent[node]);  // 재귀 함수의 형태로 구현 : 경로 압축 부분
  }
}
class pNode implements Comparable<pNode> {
  int start;
  int end;
  int value;
  pNode (int start, int end, int value) {
    this.start = start;
    this.end = end;
    this.value = value;
  }
  @Override
  public int compareTo(pNode o) {
    // 가중치를 기준으로 오름차순 정렬을 하기 위해 compareTo 재정의하기
    return this.value - o.value;
  }
}
