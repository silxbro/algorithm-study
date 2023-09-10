package src.book.ch08;

import javax.naming.ldap.StartTlsRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class exam066_불우이웃돕기 {
  static int computerNumber;
  static int[] parent;
  static int wholeLength;
  static PriorityQueue<lEdge> queue;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    computerNumber = Integer.parseInt(br.readLine());
    parent = new int[computerNumber];
    for (int i = 0; i < computerNumber; i++) {
      parent[i] = i;
    }
    wholeLength = 0;
    queue = new PriorityQueue<>();
    for (int i = 0; i < computerNumber; i++) {
      st = new StringTokenizer(br.readLine());
      String tempStr = st.nextToken();
      for (int j = 0; j < computerNumber; j++) {
        char now = tempStr.charAt(j);
        int length = 0;
        if (now >= 'a' && now <= 'z')
          length = now - 'a' + 1;
        else if (now >= 'A' && now <= 'Z')
          length = now - 'A' + 27;
        wholeLength += length;  // 총 랜선의 길이 저장하기
        if (i != j && length != 0) {
          queue.add(new lEdge(i, j, length));
        }
      }
    }
    int useEdge = 0;
    int minLength = 0;
    while (!queue.isEmpty()) {  // 최소 신장 트리 알고리즘 수행하기
      lEdge now = queue.poll();
      if (find(now.start) != find(now.end)) {  // 같은 부모가 아니라면 연결할 수 있음
        union(now.start, now.end);
        minLength += now.value;
        useEdge++;
      }
    }

    if (useEdge == computerNumber - 1) {
      System.out.println(wholeLength - minLength);
    } else {
      System.out.println(-1);
    }
  }
  private static void union(int nodeA, int nodeB) {  // union 연산 : 대표 노드끼리 연결하기
    nodeA = find(nodeA);
    nodeB = find(nodeB);
    if (nodeA != nodeB) {
      parent[nodeB] = nodeA;
    }
  }
  private static int find(int node) {                // find 연산
    if (node == parent[node]) {
      return node;
    }
    return parent[node] = find(parent[node]);  // 재귀 함수의 형태로 구현 -> 경로 압축 부분
  }
}
class lEdge implements Comparable<lEdge> {
  int start;
  int end;
  int value;
  lEdge (int start, int end, int value) {
    this.start = start;
    this.end = end;
    this.value = value;
  }
  public int compareTo(lEdge o) {
    return this.value - o.value;
  }

}
