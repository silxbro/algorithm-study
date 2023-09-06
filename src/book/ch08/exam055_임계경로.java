package src.book.ch08;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class exam055_임계경로 {
  static ArrayList<rEdge>[] linkInfo, reverseLinkInfo;
  static int[] criticalDistance;
  static int[] indegree;
  static boolean[] visited;
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int criticalValue = 0;
    int criticalRoadCount = 0;
    // 변수 초기화
    int cityNumber = Integer.parseInt(br.readLine());   // 도시 수
    int roadNumber = Integer.parseInt(br.readLine());   // 도로 수
    linkInfo = new ArrayList[cityNumber + 1];
    reverseLinkInfo = new ArrayList[cityNumber + 1];
    criticalDistance = new int[cityNumber + 1];
    indegree = new int[cityNumber + 1];
    visited = new boolean[cityNumber + 1];
    for (int i = 1; i <= cityNumber; i++) {
      linkInfo[i] = new ArrayList<>();
      reverseLinkInfo[i] = new ArrayList<>();
    }
    StringTokenizer st;
    for (int i = 0; i < roadNumber; i++) {
      st = new StringTokenizer(br.readLine());
      int start = Integer.parseInt(st.nextToken());
      int end = Integer.parseInt(st.nextToken());
      int len = Integer.parseInt(st.nextToken());
      linkInfo[start].add(new rEdge(end, len));
      reverseLinkInfo[end].add(new rEdge(start, len));   // 역방향 에지 정보 저장하기
      indegree[end]++;
    }
    st = new StringTokenizer(br.readLine());
    int startCity = Integer.parseInt(st.nextToken());
    int endCity = Integer.parseInt(st.nextToken());

    // 임계경로값 구하기 (위상 정렬)
    Queue<Integer> queue = new LinkedList<>();
    queue.add(startCity);
    while (!queue.isEmpty()) {
      int nowCity = queue.poll();
      for (rEdge next : linkInfo[nowCity]) {
        int nextCity = next.index;
        int lenToNextCity = next.value;
        indegree[nextCity]--;
        criticalDistance[nextCity] = Math.max(criticalDistance[nextCity], criticalDistance[nowCity] + lenToNextCity);
        if (indegree[nextCity] == 0) {
          queue.add(nextCity);
        }
      }
    }
    criticalValue = criticalDistance[endCity];

    // 1분도 쉬지 않고 달려야 하는 도로 수 구하기 (위상 정렬 reverse)
    queue = new LinkedList<>();
    queue.add(endCity);
    visited[endCity] = true;
    while (!queue.isEmpty()) {
      int nowCity = queue.poll();
      for (rEdge next : reverseLinkInfo[nowCity]) {
        int nextCity = next.index;
        int lenToNextCity = next.value;
        // 1분도 쉬지 않는 도로 체크하기
        if (criticalDistance[nextCity] + lenToNextCity == criticalDistance[nowCity]) {
          criticalRoadCount++;
          // 중복 카운트 방지를 위해 이미 방문한 적이 있는 노드 제외하기
          if (!visited[nextCity]) {
            visited[nextCity] = true;
            queue.add(nextCity);
          }
        }
      }
    }
    System.out.println(criticalValue);
    System.out.println(criticalRoadCount);
  }
}
class rEdge {
  int index;
  int value;
  rEdge (int index, int value) {
    this.index = index;
    this.value = value;
  }
}
