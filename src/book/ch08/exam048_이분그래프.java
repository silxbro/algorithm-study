package src.book.ch08;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class exam048_이분그래프 {
  static ArrayList<Integer>[] graph;
  static boolean[] visited;
  static int[] group;
  static boolean isEven;
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int testCase = Integer.parseInt(br.readLine());
    for (int test = 0; test < testCase; test++) {
      String[] temp = br.readLine().split(" ");
      isEven = true;
      int nodeCount = Integer.parseInt(temp[0]);
      int edgeCount = Integer.parseInt(temp[1]);
      graph = new ArrayList[nodeCount + 1];
      for (int i = 1; i <= nodeCount; i++) {
        graph[i] = new ArrayList<>();
      }
      for (int i = 0; i < edgeCount; i++) {
        temp = br.readLine().split(" ");
        int nodeA = Integer.parseInt(temp[0]);
        int nodeB = Integer.parseInt(temp[1]);
        graph[nodeA].add(nodeB);
        graph[nodeB].add(nodeA);
      }
      // 주어진 그래프가 1개로 연결돼 있다는 보장이 없으므로 모든 노드에서 수행하기
      for (int i = 1; i <= nodeCount; i++) {
        visited = new boolean[nodeCount + 1];
        group = new int[nodeCount + 1];
        DFS(i);
        if (!isEven) break;
      }
      if (isEven) {
        System.out.println("YES");
      } else {
        System.out.println("NO");
      }
    }
  }
  private static void DFS(int nowNode) {     // DFS 구현하기
    visited[nowNode] = true;
    for (int nextNode : graph[nowNode]) {
      if (!visited[nextNode]) {
        // 인접한 노드는 같은 집합이 아니므로 이전 노드와 다른 집합으로 처리하기
        group[nextNode] = (group[nowNode] + 1) % 2;
        DFS(nextNode);
      }
      // 이미 방문한 노드가 현재 노드와 같은 집합이면 이분 그래프가 아님
      else {
        if (group[nextNode] == group[nowNode]) {
          isEven = false;
          return;
        }
      }
    }
  }
}
