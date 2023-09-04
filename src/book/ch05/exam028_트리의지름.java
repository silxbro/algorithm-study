package src.book.ch05;

import java.util.*;

public class exam028_트리의지름 {
  static ArrayList<Edge>[] tree;
  static boolean[] visited;
  static int[] distance;
  static int nodeCount;
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    nodeCount = sc.nextInt();
    tree = new ArrayList[nodeCount + 1];
    for (int node = 1; node <= nodeCount; node++) {
      tree[node] = new ArrayList<>();
    }
    for (int node = 1; node <= nodeCount; node++) {  // 인접 리스트에 그래프 데이터 저장하기
      int startNode  = sc.nextInt();
      while (true) {
        int endNode = sc.nextInt();
        if (endNode == -1) break;
        int edgeLength = sc.nextInt();
        tree[startNode].add(new Edge(endNode, edgeLength));
      }
    }
    visited = new boolean[nodeCount + 1];
    distance = new int[nodeCount + 1];
    BFS(1);
    int newStartNode = 1;
    for (int node = 2; node <= nodeCount; node++) {  // distance 배열에서 가장 큰 값으로 다시 시작점 설정
      if (distance[node] > distance[newStartNode]) {
        newStartNode = node;
      }
    }
    visited = new boolean[nodeCount + 1];
    distance = new int[nodeCount + 1];
    BFS(newStartNode);   // 새로운 시작점으로 실행
    Arrays.sort(distance);
    int diameter = distance[nodeCount];
    System.out.println(diameter);
  }
  public static void BFS(int nodeNum) {     // BFS 구현하기
    Queue<Integer> queue = new LinkedList<>();
    queue.add(nodeNum);
    visited[nodeNum] = true;
    while (!queue.isEmpty()) {
      int now = queue.poll();
      visited[now] = true;
      for (Edge next : tree[now]) {
        if (!visited[next.num]) {
          visited[next.num] = true;
          queue.add(next.num);
          distance[next.num] = distance[now] + next.len;   // 거리 배열 업데이트
        }
      }
    }
  }
}
class Edge {
  int num;
  int len;
  Edge (int num, int len) {
    this.num = num;
    this.len = len;
  }
}
