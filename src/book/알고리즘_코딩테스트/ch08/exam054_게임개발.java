package src.book.알고리즘_코딩테스트.ch08;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class exam054_게임개발 {
  static int[] selfBuild;   // 각 건물을 짓는 데 걸리는 시간
  static int[] result;      // 각 건물을 짓는 데 걸리는 누적 시간(위상 정렬 수행 후)
  static ArrayList<ArrayList<Integer>> buildOrderGraph = new ArrayList<>();
  static int[] indegree;
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    int buildingNumber = Integer.parseInt(br.readLine());
    indegree = new int[buildingNumber + 1];
    selfBuild = new int[buildingNumber + 1];
    result = new int[buildingNumber + 1];
    for (int i = 0; i <= buildingNumber; i++) {
      buildOrderGraph.add(new ArrayList<>());
    }

    for (int i = 1; i <= buildingNumber; i++) {
      st = new StringTokenizer(br.readLine());
      selfBuild[i] = Integer.parseInt(st.nextToken());
      while (true) {    // 인접 리스트 초기화
        int inFrontOf = Integer.parseInt(st.nextToken());
        if (inFrontOf == -1) {
          break;
        }
        buildOrderGraph.get(inFrontOf).add(i);
        indegree[i]++;  // 진입 차수 배열 초기화
      }
    }
    // 위상 정렬
    Queue<Integer> queue = new LinkedList<>();
    for (int i = 1; i <= buildingNumber; i++) {
      if (indegree[i] == 0) {
        queue.add(i);
      }
    }
    while (!queue.isEmpty()) {
      int nowBuilding = queue.poll();
      for (int nextBuilding : buildOrderGraph.get(nowBuilding)) {
        indegree[nextBuilding]--;
        // *** 시간 업데이트 (핵심 로직)
        result[nextBuilding] = Math.max(result[nextBuilding], result[nowBuilding] + selfBuild[nowBuilding]);
        if (indegree[nextBuilding] == 0) {
          queue.add(nextBuilding);
        }
      }
    }

    for (int i = 1; i <= buildingNumber; i++) {
      System.out.println(result[i] + selfBuild[i]);
    }
  }
}
