package src.book.ch08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class exam056_최단경로 {
  static ArrayList<dNode>[] graph;
  static int[] distance;
  static boolean[] visited;
  static PriorityQueue<dNode> queue = new PriorityQueue<>();
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int nodeNumber = Integer.parseInt(st.nextToken());
    int edgeNumber = Integer.parseInt(st.nextToken());
    int startNode = Integer.parseInt(br.readLine());
    distance = new int[nodeNumber + 1];
    visited = new boolean[nodeNumber + 1];
    Arrays.fill(distance, Integer.MAX_VALUE);
    graph = new ArrayList[nodeNumber + 1];
    for (int i = 1; i <= nodeNumber; i++) {
      graph[i] = new ArrayList<>();
    }
    for (int i = 0; i < edgeNumber; i++) {     // 가중치가 있는 인접 리스트 초기화하기
      st = new StringTokenizer(br.readLine());
      int sNode = Integer.parseInt(st.nextToken());
      int eNode = Integer.parseInt(st.nextToken());
      int wValue = Integer.parseInt(st.nextToken());
      graph[sNode].add(new dNode(eNode, wValue));
    }
    
    queue.add(new dNode(startNode, 0));
    distance[startNode] = 0;
    while (!queue.isEmpty()) {
      dNode now = queue.poll();
      if (!visited[now.index]) {
        visited[now.index] = true;
        for (dNode next : graph[now.index]) {
          if (distance[next.index] > distance[now.index] + next.value) {   // 최소 거리로 업데이트하기
            distance[next.index] = distance[now.index] + next.value;
            queue.add(new dNode(next.index, distance[next.index]));
          }
        }
      }
    }
    for (int i = 1; i <= nodeNumber; i++) {    // 거리 배열 출력하기
      if (visited[i]) {
        System.out.println(distance[i]);
      } else {
        System.out.println("INF");
      }
    }
  }
}
class dNode implements Comparable<dNode> {
  int index;
  int value;
  dNode (int index, int value) {
    this.index = index;
    this.value = value;
  }
  @Override
  public int compareTo(dNode o) {
    return this.value - o.value;
  }
}
