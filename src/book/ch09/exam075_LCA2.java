package src.book.ch09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.*;

public class exam075_LCA2 {
  static ArrayList<Integer>[] tree;
  static int[][] parent;
  static int[] depth;
  static boolean[] visited;
  static int kmax;
  public static void main(String[] args) throws NumberFormatException, IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    int nodeNumber = Integer.parseInt(br.readLine());
    tree = new ArrayList[nodeNumber + 1];
    for (int i = 1; i <= nodeNumber; i++) {
      tree[i] = new ArrayList<>();
    }
    for (int i = 0; i < nodeNumber - 1; i++) {              // A 인접 리스트에 그래프 데이터 저장하기
      st = new StringTokenizer(br.readLine());
      int nodeA = Integer.parseInt(st.nextToken());
      int nodeB = Integer.parseInt(st.nextToken());
      tree[nodeA].add(nodeB);
      tree[nodeB].add(nodeA);
    }
    depth = new int[nodeNumber + 1];
    visited = new boolean[nodeNumber + 1];
    kmax = 0;
    int temp = 1;
    while (temp <= nodeNumber) {                            // 최대 가능 depth 구하기
      temp <<= 1;
      kmax++;
    }
    parent = new int[kmax + 1][nodeNumber + 1];
    BFS(1);                                       // depth를 BFS를 이용해 구하기
    for (int k = 1; k <= kmax; k++) {
      for (int n = 1; n <= nodeNumber; n++) {
        parent[k][n] = parent[k-1][parent[k-1][n]];
      }
    }
    int requestNumber = Integer.parseInt(br.readLine());    // 질의 수
    for (int i = 0; i < requestNumber; i++) {
      // 공통 조상을 구할 두 노드
      st = new StringTokenizer(br.readLine());
      int nodeA = Integer.parseInt(st.nextToken());
      int nodeB = Integer.parseInt(st.nextToken());
      int LCA = executeLCA(nodeA, nodeB);
      System.out.println(LCA);
    }
  }
  private static void BFS(int nodeNum) {
    Queue<Integer> queue = new LinkedList<>();
    queue.add(nodeNum);
    visited[nodeNum] = true;
    int level = 1;
    int setCount = 1;
    int count = 0;
    while (!queue.isEmpty()) {
      int nowNode = queue.poll();
      for (int nextNode : tree[nowNode]) {
        if (!visited[nextNode]) {
          visited[nextNode] = true;
          queue.add(nextNode);
          parent[0][nextNode] = nowNode;                    // 부모 노드 저장하기
          depth[nextNode] = level;                          // 노드 depth 저장하기
        }
      }
      count++;
      if (count == setCount) {
        count = 0;
        setCount = queue.size();
        level++;
      }
    }
  }
  private static int executeLCA(int nodeNum1, int nodeNum2) {
    if (depth[nodeNum1] > depth[nodeNum2]) {                  // 더 깊은 depth가 b가 되도록 변경하기
      int temp = nodeNum1;
      nodeNum1 = nodeNum2;
      nodeNum2 = temp;
    }
    for (int k = kmax; k >= 0; k--) {                         // depth를 빠르게 맞추기
      if (Math.pow(2,k) <= depth[nodeNum2] - depth[nodeNum1]) {
        if (depth[nodeNum1] <= depth[parent[k][nodeNum2]]) {
          nodeNum2 = parent[k][nodeNum2];
        }
      }
    }
    for (int k = kmax; k >= 0 && nodeNum1 != nodeNum2; k--) { // ***조상 빠르게 찾기
      if (parent[k][nodeNum1] != parent[k][nodeNum2]) {
        nodeNum1 = parent[k][nodeNum1];
        nodeNum2 = parent[k][nodeNum2];
      }
    }
    int LCA = nodeNum1;
    if (nodeNum1 != nodeNum2) {
      LCA = parent[0][LCA];
    }
    return LCA;
  }
}
