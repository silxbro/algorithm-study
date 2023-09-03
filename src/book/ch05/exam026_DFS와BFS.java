package src.book.ch05;

import java.util.*;

public class exam026_DFS와BFS {
  static ArrayList<Integer>[] graph;
  static boolean[] visited;
  static int nodeCount;
  static int edgeCount;
  static int startNode;
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    nodeCount = sc.nextInt();
    edgeCount = sc.nextInt();
    startNode = sc.nextInt();
    graph = new ArrayList[nodeCount + 1];
    for (int node = 1; node <= nodeCount; node++) {
      graph[node] = new ArrayList<>();
    }
    for (int edge = 0; edge < edgeCount; edge++) {
      int nodeA = sc.nextInt();
      int nodeB = sc.nextInt();
      graph[nodeA].add(nodeB);
      graph[nodeB].add(nodeA);
    }
    // 번호가 작은 것을 먼저 방문하기 위해 정렬하기
    for (int node = 1; node <= nodeCount; node++) {
      Collections.sort(graph[node]);
    }
    // DFS 실행
    visited = new boolean[nodeCount + 1];  // 방문 배열 초기화
    DFS(startNode);
    System.out.println();
    // BFS 실행
    visited = new boolean[nodeCount + 1];  // 방문 배열 초기화
    BFS(startNode);
  }
  public static void DFS(int nodeNum) {    // DFS 구현
    visited[nodeNum] = true;
    System.out.print(nodeNum + " ");
    for (int nextNode : graph[nodeNum]) {
      if (!visited[nextNode]) {
        DFS(nextNode);
      }
    }
  }
  public static void BFS(int nodeNum) {    // BFS 구현
    Queue<Integer> queue = new LinkedList<>();
    queue.add(nodeNum);
    visited[nodeNum] = true;
    while (!queue.isEmpty()) {
      int nowNode = queue.poll();
      System.out.print(nowNode + " ");
      for (int nextNode : graph[nowNode]) {
        if (!visited[nextNode]) {
          visited[nextNode] = true;
          queue.add(nextNode);
        }
      }
    }
  }
}
