package src.book.ch09;

import java.util.*;

public class exam074_LCA {
  static ArrayList<Integer>[] tree;
  static int[] parent;
  static int[] depth;
  static boolean[] visited;
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int nodeNumber = sc.nextInt();              // 노드의 수
    tree = new ArrayList[nodeNumber + 1];
    for (int i = 1; i <= nodeNumber; i++) {
      tree[i] = new ArrayList<>();
    }
    for (int i = 0; i < nodeNumber - 1; i++) {  // A 인접 리스트에 그래프 데이터 저장하기
      int nodeA = sc.nextInt();
      int nodeB = sc.nextInt();
      tree[nodeA].add(nodeB);
      tree[nodeB].add(nodeA);
    }
    
    parent = new int[nodeNumber + 1];
    depth = new int[nodeNumber + 1];
    visited = new boolean[nodeNumber + 1];
    BFS(1);                           // depth를 BFS를 이용해 구하기

    int requestNumber = sc.nextInt();           // 질의의 수
    for (int i = 0; i < requestNumber; i++) {
      // 공통 조상을 구할 두 노드
      int nodeA = sc.nextInt();
      int nodeB = sc.nextInt();
      int LCA = executeLCA(nodeA, nodeB);
      System.out.println(LCA);
    }
  }
  // BFS 구현하기
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
          parent[nextNode] = nowNode;  // 부모 노드 저장하기
          depth[nextNode] = level;     // 노드 depth 저장하기
        }
      }
      count++;
      if (count == setCount) {
        setCount = queue.size();
        count = 0;
        level++;
      }
    }
  }
  private static int executeLCA(int nodeNum1, int nodeNum2) {
    if (depth[nodeNum1] < depth[nodeNum2]) {
      int temp = nodeNum1;
      nodeNum1 = nodeNum2;
      nodeNum2 = temp;
    }
    while (depth[nodeNum1] != depth[nodeNum2]) {    // 두 노드의 depth 맞추기
      nodeNum1 = parent[nodeNum1];
    }

    while (nodeNum1 != nodeNum2) {                  // 같은 조상이 나올 때까지 한 칸씩 올리기
      nodeNum1 = parent[nodeNum1];
      nodeNum2 = parent[nodeNum2];
    }
    return nodeNum1;
  }
}
