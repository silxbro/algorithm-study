package src.book.ch05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class exam023_연결요소의개수 {
  static ArrayList<Integer>[] graph;
  static boolean[] visited;
  static int linkedComponentCount;
  static int nodeCount;
  static int edgeCount;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
    StringTokenizer st = new StringTokenizer(br.readLine());
    nodeCount = Integer.parseInt(st.nextToken());
    edgeCount = Integer.parseInt(st.nextToken());
    graph = new ArrayList[nodeCount + 1];
    visited = new boolean[nodeCount + 1];
    for (int i = 1; i <= nodeCount; i++) {
      graph[i] = new ArrayList<>();      // 인접 리스트 초기화하기
    }
    for (int i = 0; i < edgeCount; i++) {
      st = new StringTokenizer(br.readLine());
      int nodeA = Integer.parseInt(st.nextToken());
      int nodeB = Integer.parseInt(st.nextToken());
      graph[nodeA].add(nodeB);           // 양방향 에지이므로 양쪽에 에지를 더하기
      graph[nodeB].add(nodeA);
    }
    for (int i = 1; i <= nodeCount; i++) {
      if (!visited[i]) {         // 방문하지 않은 노드가 없을 때까지 반복하기
        linkedComponentCount++;
        DFS(i);
      }
    }
    System.out.println(linkedComponentCount);
  }
  public static void DFS(int nodeNum) {
    visited[nodeNum] = true;
    for (int next : graph[nodeNum]) {
      if (!visited[next]) {
        DFS(next);
      }
    }
  }
}
