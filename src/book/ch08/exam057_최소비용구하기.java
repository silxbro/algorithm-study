package src.book.ch08;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class exam057_최소비용구하기 {
  static int cityNumber, busNumber;
  static ArrayList<cNode>[] costInfo;    // 인접 리스트로 그래프 표현
  static int[] cost;                     // 최단 거리 배열
  static boolean[] visited;              // 사용 노드인지 확인 배열
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st;
    cityNumber = Integer.parseInt(br.readLine());
    busNumber = Integer.parseInt(br.readLine());
    cost = new int[cityNumber + 1];
    visited = new boolean[cityNumber + 1];
    costInfo = new ArrayList[cityNumber + 1];
    for (int i = 1; i <= cityNumber; i++) {
      costInfo[i] = new ArrayList<>();
    }
    Arrays.fill(cost, Integer.MAX_VALUE);   // 거리 배열을 충분히 큰 수로 초기화하기
    for (int i = 0; i < busNumber; i++) {   // 주어진 그래프의 에지를 인접 리스트 자료구조에 넣기
      st = new StringTokenizer(br.readLine());
      int start = Integer.parseInt(st.nextToken());
      int end = Integer.parseInt(st.nextToken());
      int cost = Integer.parseInt(st.nextToken());
      costInfo[start].add(new cNode(end, cost));
    }
    st = new StringTokenizer(br.readLine());
    int startCity = Integer.parseInt(st.nextToken());
    int endCity = Integer.parseInt(st.nextToken());
    bw.write(dijkstra(startCity, endCity) + "\n");  // 다익스트라 알고리즘 수행하기
    bw.flush();
    bw.close();
    br.close();
  }
  private static int dijkstra(int startIndex, int endIndex) {  // 다익스트라 알고리즘
    PriorityQueue<cNode> queue = new PriorityQueue<>();
    queue.add(new cNode(startIndex, 0));
    cost[startIndex] = 0;
    while (!queue.isEmpty()) {
      cNode now = queue.poll();
      if (visited[now.index]) continue;
      visited[now.index] = true;
      for (cNode next : costInfo[now.index]) {  // 선택 노드 + 비용 < 타깃 노드일 때 값을 업데이트
        if (cost[next.index] > cost[now.index] + next.value) {
          cost[next.index] = cost[now.index] + next.value;
          queue.add(new cNode(next.index, cost[next.index]));
        }
      }
    }
    return cost[endIndex];
  }
}
class cNode implements Comparable<cNode> {
  int index;
  int value;
  cNode (int index, int value) {
    this.index = index;
    this.value = value;
  }
  @Override
  public int compareTo(cNode o) {
    return this.value - o.value;
  }
}
